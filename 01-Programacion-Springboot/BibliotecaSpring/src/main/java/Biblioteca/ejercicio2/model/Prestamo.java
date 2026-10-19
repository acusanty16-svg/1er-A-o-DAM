package Biblioteca.ejercicio2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entidad que representa la tabla "prestamos" en la base de datos.
 * Un préstamo conecta un libro con un usuario.
 */
@Entity
@Table(name = "prestamos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    //Muchos prestamos pueden referenciar a un mismo libro
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
