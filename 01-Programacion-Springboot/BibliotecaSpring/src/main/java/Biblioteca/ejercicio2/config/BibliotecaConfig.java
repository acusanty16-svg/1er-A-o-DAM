package Biblioteca.ejercicio2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "biblioteca")
public class BibliotecaConfig {
    private String nombre = "Mi Biblioteca";
    private int maxPrestamos = 5;
    private String version = "1.0";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMaxPrestamos() {
        return maxPrestamos;
    }

    public void setMaxPrestamos(int maxPrestamos) {
        this.maxPrestamos = maxPrestamos;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
