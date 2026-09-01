package model;

import java.util.ArrayList;
import java.util.List;

public class SalonClase {
    private List<Estudiante> salonClase;

    public SalonClase () {
        this.salonClase = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante){
        if (estudiante == null || estudiante.getDni() == null) {
            System.out.println("Estudiante o DNI invalido");
            return;
        }

        boolean existe = salonClase.stream()
                .anyMatch(item -> item.getDni() != null
                        && item.getDni().equalsIgnoreCase(estudiante.getDni()));
        if (!existe){
            salonClase.add(estudiante);
            estudiante.setCalificacion(Math.random() * 10);
        } else {
            System.out.println("El estudiante ya esta registrado");
        }
    }
    public void mostrarDatos () {
        if (salonClase.isEmpty()){
            System.out.println("El aula esta vacia y no podemos hacer nada");
        }else {
            salonClase.forEach(System.out::println);
        }
    }

    public List<Estudiante> getSalonClase() {
        return salonClase;
    }

    public void setSalonClase(List<Estudiante> salonClase) {
        this.salonClase = salonClase;
    }
}
