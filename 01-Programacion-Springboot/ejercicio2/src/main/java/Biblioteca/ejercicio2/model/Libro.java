package Biblioteca.ejercicio2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Entidad que representa la tabla "libros" en la base de datos.
 * Un libro pertenece a un autor (relación @ManyToOne).
 */
@Entity
@Table(name = "libros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private boolean prestado = false;

    // Muchos libros pertenecen a un autor
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
