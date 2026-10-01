package com.example.E_commerce.ejercicio3.service;

import com.example.E_commerce.ejercicio3.DTO.PedidoDTO;
import com.example.E_commerce.ejercicio3.DTO.PedidoItemDTO;
import com.example.E_commerce.ejercicio3.exception.CarritoVacioException;
import com.example.E_commerce.ejercicio3.exception.PedidoNotFoundException;
import com.example.E_commerce.ejercicio3.exception.StockInsuficienteException;
import com.example.E_commerce.ejercicio3.exception.UsuarioNotFoundException;
import com.example.E_commerce.ejercicio3.model.*;
import com.example.E_commerce.ejercicio3.repository.CarritoRepository;
import com.example.E_commerce.ejercicio3.repository.PedidoRepository;
import com.example.E_commerce.ejercicio3.repository.ProductoRepository;
import com.example.E_commerce.ejercicio3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/*
 Servicio de la capa de negocio encargado de la gestion de pedidos del E-commerce.
 Administra la creacion de un pedido a partir del carrito del usuario, el control
 de stock y las consultas de los pedidos registrados.
 y a continuacion se presenta los metodos para tener un crud estable y profesional
    -Inyectamos 4 repositorios UsuarioRepository, PedidoRepository, CarritoRepository,
    ProductoRepository y el servicio CarritoService

                               ----METODOS PRIVADOS----
    -toDto: convierte un Pedido en su PedidoDTO de salida con sus items
    -toItemDto:   convierte un PedidoItem en su PedidoItemDTO calculando su subtotal

                              ----METODOS PUBLICOS----
    -createPedido: crea un pedido a partir del carrito del usuario descontando stock
    y vaciando el carrito cuando la compra se confirma
    (operacion transaccional: si falla algo se revierte todo)
    -findAll: devuelve todos los pedidos registrados (uso de administracion)
    -findById:    devuelve un pedido concreto por su identificador
     -findByUsuario: devuelve los pedidos de un usuario ordenados por fecha
 */
@Service
public class PedidoService {
    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;
    private final CarritoRepository carritoRepository;
    private final CarritoService carritoService;
    private final ProductoRepository productoRepository;

    public PedidoService(UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository, CarritoRepository carritoRepository, CarritoService carritoService, ProductoRepository productoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.pedidoRepository = pedidoRepository;
        this.carritoRepository = carritoRepository;
        this.carritoService = carritoService;
        this.productoRepository = productoRepository;
    }

    // METODOS HELPERS PRIVADOS

    private PedidoDTO toDto(Pedido pedido){
        List<PedidoItemDTO> items = pedido.getItems().stream()
                .map(this::toItemDto).toList();
        return new PedidoDTO(pedido.getId(), pedido.getFecha(),pedido.getEstado(),
                pedido.getTotal(),items);
    }

    private PedidoItemDTO toItemDto (PedidoItem item){
        Double precio = item.getPrecioUnitario();
        return new PedidoItemDTO(
                item.getId(),
                item.getProducto().getId(),
                item.getNombreProducto(),
                item.getPrecioUnitario(),
                item.getCantidad(),
                precio * item.getCantidad()
        );
    }

    @Transactional
    public PedidoDTO createPedido(String username){
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(()-> new UsuarioNotFoundException(username));

        Carrito carrito = carritoRepository.findByUsuario(usuario)
                .orElseThrow(CarritoVacioException::new);

        if (carrito.getItems().isEmpty()){
            throw new CarritoVacioException();
        }

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setFecha(LocalDateTime.now());
        pedido.setEstado(EstadoPedido.PAGADO);
        double total = 0;

        for(CarritoItem item: carrito.getItems()){
            Producto producto = item.getProducto();
            if (item.getCantidad()> producto.getStock()){
                throw new StockInsuficienteException("Stock insuficiente para '"+
                        producto.getNombre() + "': disponible "+producto.getStock()
                +", solicitado "+item.getCantidad());
            }
            PedidoItem pedidoItem = new PedidoItem();
            pedidoItem.setPedido(pedido);
            pedidoItem.setProducto(producto);
            pedidoItem.setNombreProducto(producto.getNombre());
            pedidoItem.setPrecioUnitario(producto.getPrecio());
            pedidoItem.setCantidad(item.getCantidad());
            pedido.getItems().add(pedidoItem);

            producto.setStock(producto.getStock() - item.getCantidad());
            productoRepository.save(producto);

            total += producto.getPrecio() * item.getCantidad();
        }
        pedido.setTotal(total);
        Pedido guardado = pedidoRepository.save(pedido);
        carritoService.vaciarCarrito(carrito);
        return toDto(guardado);
    }

    public List<PedidoDTO> findAll(){
        return pedidoRepository.findAll().stream()
                .map(this::toDto).toList();
    }

    public PedidoDTO findById(UUID id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(()-> new PedidoNotFoundException(id));
        return toDto(pedido);
    }

    public List<PedidoDTO> findByUsuario(String username){
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(()-> new UsuarioNotFoundException(username));
        return pedidoRepository.findByUsuarioOrderByFechaDesc(usuario).stream()
                .map(this::toDto).toList();
    }
}
