package Biblioteca.ejercicio2.controller;

import Biblioteca.ejercicio2.DTO.LoginDTO;
import Biblioteca.ejercicio2.DTO.UsuarioCreateDTO;
import Biblioteca.ejercicio2.DTO.UsuarioDTO;
import Biblioteca.ejercicio2.service.JwtService;
import Biblioteca.ejercicio2.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UsuarioService usuarioService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Registrar un usuario nuevo
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@Valid @RequestBody UsuarioCreateDTO dto) {
        return ResponseEntity.ok(usuarioService.register(dto));
    }

    //Iniciar sesion y obtener token JWT
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginDTO dto){
        //autenticar usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        //Si llegamos aqui la autenticacion fue exitosa
        String token = jwtService.generateToken(dto.getUsername());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
