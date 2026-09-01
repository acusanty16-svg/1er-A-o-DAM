package com.example.ejercicio1_hola_mundo.service;

import org.springframework.stereotype.Service;

/**
 * Servicio encargado de generar saludos personalizados.
 * Lógica simple: si el nombre es null o vacío, devuelve "¡Hola, Mundo!";
 * en caso contrario, devuelve un saludo con el nombre proporcionado.
 */
@Service
public class SaludoService {

    public String generarSaludo(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return "¡Hola, Mundo!";
        }
        return "¡Hola, " + nombre + "! Bienvenido a Spring Boot";
    }
}
