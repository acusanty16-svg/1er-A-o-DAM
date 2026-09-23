package com.example.E_commerce.ejercicio3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Entidad pedidos
@Entity
@Table(name = "pedidos")
@Data
@AllArgsConstructor
@NoArgsConstructor
//Excluye la lista de items para que no existe un bucle infinito con pedidoItem
@ToString(exclude = "items")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Muchos pedidos pero un solo usuario asignado
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime fecha;

    //Referenciamos al enum para saber el estado del pedido
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estado;

    @Column(nullable = false)
    private Double total;

    /*Un pedido contine muchos items, y la clave foranea es pedidoItem, todas las acciones de crud
    se generaran en cascada y si ejecutas DELETE entonces el orphanRemoval se ejecutara y borrara el
    registro huerfano y el fetch es que cargara automaticamente al conectarse con la BD
    */
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private List<PedidoItem> items = new ArrayList<>();

}
