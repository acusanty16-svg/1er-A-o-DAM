package com.example.ejercicio1_hola_mundo;

import com.example.ejercicio1_hola_mundo.component.ContadorVisitas;
import com.example.ejercicio1_hola_mundo.service.SaludoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador principal de la aplicación.
 * Maneja las peticiones GET para la ruta raíz y /saludo.
 * Demuestra inyección de dependencias por constructor con dos beans distintos.
 */
@RestController
public class HolaController {

    private final SaludoService saludoService;
    private final ContadorVisitas contadorVisitas;

    // Spring inyecta automáticamente las dependencias al crear esta clase
    public HolaController(SaludoService saludoService, ContadorVisitas contadorVisitas) {
        this.saludoService = saludoService;
        this.contadorVisitas = contadorVisitas;
    }

    // GET / -> devuelve un saludo genérico con el contador de visitas
    @GetMapping("/")
    public String hola() {
        int totalVisitas = contadorVisitas.incrementar();
        return saludoService.generarSaludo(null) + " | Visitas: " + totalVisitas;
    }

    // GET /saludo?nombre=Carlos -> devuelve un saludo personalizado
    @GetMapping("/saludo")
    public String saludo(@RequestParam String nombre) {
        int totalVisitas = contadorVisitas.incrementar();
        return saludoService.generarSaludo(nombre) + " | Visitas: " + totalVisitas;
    }
}
