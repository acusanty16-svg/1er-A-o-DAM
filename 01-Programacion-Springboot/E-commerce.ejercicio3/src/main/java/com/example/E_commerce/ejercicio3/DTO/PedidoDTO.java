package com.example.E_commerce.ejercicio3.DTO;

import com.example.E_commerce.ejercicio3.model.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 DTO de respuesta para la entidad Pedido.
 Envía solo la información necesaria al cliente.
 */

public class PedidoDTO {

    private UUID id;
    private LocalDateTime fecha;
    private EstadoPedido estado;
    private Double total;
    private List<PedidoItemDTO> items;
}
