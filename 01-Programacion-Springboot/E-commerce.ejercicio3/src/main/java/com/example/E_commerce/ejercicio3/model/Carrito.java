package com.example.E_commerce.ejercicio3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Entidad de carrito
@Entity
@Table(name = "carritos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "items")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    /*Este aspecto es bastante interesante porque decidimos que un usuario
    tiene un solo carrito y no varios porque es mas e-commerce
    */
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    //Un carrito tiene muchos items, pero un solo carrito
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CarritoItem> items = new ArrayList<>();

}
