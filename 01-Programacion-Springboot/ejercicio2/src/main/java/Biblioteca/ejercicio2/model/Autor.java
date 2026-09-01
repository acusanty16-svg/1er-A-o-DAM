package Biblioteca.ejercicio2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Entidad que representa la tabla "autores" en la base de datos.
 * Un autor puede tener muchos libros (relación @OneToMany).
 */
@Entity
@Table(name = "autores")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nombre;

    // Un autor tiene muchos libros
    // mappedBy = "autor" indica que la clase Libro tiene el campo "autor"
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();
}