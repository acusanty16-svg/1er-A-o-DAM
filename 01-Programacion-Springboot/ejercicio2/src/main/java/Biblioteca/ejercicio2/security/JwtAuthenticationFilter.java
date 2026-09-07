package Biblioteca.ejercicio2.security;

import Biblioteca.ejercicio2.model.Usuario;
import Biblioteca.ejercicio2.repository.UsuarioRepository;
import Biblioteca.ejercicio2.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;

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
        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwt = authHeader.substring(7);

        final String userEmail;
        try {
            userEmail = jwtService.extractUsername(jwt);
        } catch (Exception e) {
            writeErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Token inválido", request.getRequestURI());
            return;
        }

        if (userEmail == null) {
            writeErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Token inválido", request.getRequestURI());
            return;
        }

        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            Usuario usuario = usuarioRepository.findByUsername(userEmail).orElse(null);

            if (usuario != null && jwtService.isTokenValid(jwt, usuario.getUsername())) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        java.util.List.of(new org.springframework.security.core.authority.SimpleGrantedAuthority
                                (usuario.getRole().name()))
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            } else {
                writeErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Usuario no encontrado", request.getRequestURI());
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private void writeErrorResponse(HttpServletResponse response, int status, String message, String path) throws IOException {
        response.setStatus(status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        String json = String.format(
                "{\"timestamp\":\"%s\",\"status\":%d,\"error\":\"%s\",\"message\":\"%s\",\"path\":\"%s\"}",
                LocalDateTime.now(),
                status,
                status == 401 ? "Unauthorized" : "Forbidden",
                message,
                path
        );

        response.getWriter().write(json);
        response.getWriter().flush();
    }
}
