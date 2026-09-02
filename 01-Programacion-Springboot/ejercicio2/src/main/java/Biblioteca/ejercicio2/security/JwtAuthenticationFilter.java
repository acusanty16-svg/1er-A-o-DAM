package Biblioteca.ejercicio2.security;

import Biblioteca.ejercicio2.model.Usuario;
import Biblioteca.ejercicio2.repository.UsuarioRepository;
import Biblioteca.ejercicio2.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro JWT que se ejecuta en cada petición.
 * 1. Extrae el token del header Authorization
 * 2. Valida el token
 * 3. Si es válido, autentica al usuario en el contexto de seguridad
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public JwtAuthenticationFilter(JwtService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Paso 1: Obtener el header Authorization
        final String authHeader = request.getHeader("Authorization");

        //Paso 2: Si no hay header o no empiezar "Bearer", dejar pasar
        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        //Paso 3: extraer el token (quitar "Bearer " del inicio)
        final String jwt = authHeader.substring(7);

        //Paso 4: Extraer el username del token
        final String userEmail = jwtService.extractUsername(jwt);

        //Paso 5: Si hay username  y no hay actualizacion previa
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){

            //Paso 6: Buscar el nombre de usuario en la base de datos
            Usuario usuario = usuarioRepository.findByUsername(userEmail).orElse(null);

            //Paso 7: Si el usuario existe y el token es valido
            if (usuario != null && jwtService.isTokenValid(jwt, usuario.getUsername())){

                //Paso 8: Autenticar al usuario con el contexto de seguridad
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        java.util.List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority
                                (usuario.getRole().name()))
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        //Paso 9: Continuar con la cadena de filtros
        filterChain.doFilter(request, response);
    }
}
