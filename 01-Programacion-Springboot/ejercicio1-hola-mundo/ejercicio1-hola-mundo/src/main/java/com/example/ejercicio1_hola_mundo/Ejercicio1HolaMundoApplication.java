package com.example.ejercicio1_hola_mundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot.
 * @SpringBootApplication activa la autoconfiguración, el escaneo de componentes
 * y la configuración de las propiedades. Spring busca automáticamente todos los
 * beans (@Service, @Repository, @Controller, etc.) en este paquete y subpaquetes.
 */
@SpringBootApplication
public class Ejercicio1HolaMundoApplication {

    public static void main(String[] args) {
        // Arranca el servidor Tomcat embebido y carga toda la aplicación
        SpringApplication.run(Ejercicio1HolaMundoApplication.class, args);
    }
}
