package com.example.ejercicio1_hola_mundo.component;

import org.springframework.stereotype.Component;

/**
 * Componente que lleva el conteo de visitas a la aplicación.
 * Se mantiene en memoria (se reinicia cada vez que se para la app).
 * Anotado con @Component para que Spring lo gestione como un bean.
 */
@Component
public class ContadorVisitas {

    private int visitas = 0;

    // Incrementa el contador y devuelve el valor actual
    public int incrementar() {
        return ++visitas;
    }

    public int getVisitas() {
        return visitas;
    }
}
