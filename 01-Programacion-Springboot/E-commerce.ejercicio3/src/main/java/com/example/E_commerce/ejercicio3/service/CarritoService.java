package com.example.E_commerce.ejercicio3.service;

import com.example.E_commerce.ejercicio3.DTO.CarritoDTO;
import com.example.E_commerce.ejercicio3.DTO.CarritoItemCreateDTO;
import com.example.E_commerce.ejercicio3.DTO.CarritoItemDTO;
import com.example.E_commerce.ejercicio3.DTO.CarritoItemUpdateDTO;
import com.example.E_commerce.ejercicio3.exception.CarritoItemNotFoundException;
import com.example.E_commerce.ejercicio3.exception.ProductoNotFoundException;
import com.example.E_commerce.ejercicio3.exception.StockInsuficienteException;
import com.example.E_commerce.ejercicio3.exception.UsuarioNotFoundException;
import com.example.E_commerce.ejercicio3.model.Carrito;
import com.example.E_commerce.ejercicio3.model.CarritoItem;
import com.example.E_commerce.ejercicio3.model.Producto;
import com.example.E_commerce.ejercicio3.model.Usuario;
import com.example.E_commerce.ejercicio3.repository.CarritoItemRepository;
import com.example.E_commerce.ejercicio3.repository.CarritoRepository;
import com.example.E_commerce.ejercicio3.repository.ProductoRepository;
import com.example.E_commerce.ejercicio3.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
Servicio de la capa de negocio encargado de la gestión del carrito de compras.
Administra la creación, consulta y manipulación de carritos e ítems asociados a un usuario.
y a continuacion se presenta los metodos para tener un crud estable y profesional
    -Inyectamos 4 repositorios UsuarioRepository, CarritoRepository, CarritoItemRepository
    y ProductoRepository
                            ----METODOS PRIVADOS----
    -ObtenerOCrearCarrito: seleciona a un usuario un unico carrito y si no existe lo crea
    -toDto: convierte el carrito en su DTO de respuesta con el total calculado de todos sus items
    -toItemDto: convierte cada item del carrito en su DTO con el subtotal en vivo del producto
    -validarStock: Metodo de verificacion donde la cantidad solicitada no puede superar el stock

                            ----METODOS PUBLICOS----
    -getCarrito: asigna o crea un carrito para el usuarion ingresado
    -addItem: se encarga de agregar un producto al carrito de compras de un usuario o aumentar
    la cantidad de elementos dentro del carrito existente
    -updateItem: modifica la cantidad de un item del carrito tras validar el stock disponible
    -removeItem: elimina un item del carrito del usuario autenticado
    -vaciarCarrito: limpia todos los items del carrito, se usa al confirmar un pedido
*/

@Service
public class CarritoService {
    private final UsuarioRepository usuarioRepository;
    private final CarritoRepository carritoRepository;
    private final CarritoItemRepository carritoItemRepository;
    private final ProductoRepository productoRepository;

    public CarritoService(UsuarioRepository usuarioRepository, CarritoRepository carritoRepository, CarritoItemRepository carritoItemRepository, ProductoRepository productoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.carritoRepository = carritoRepository;
        this.carritoItemRepository = carritoItemRepository;
        this.productoRepository = productoRepository;
    }

    //METODOS HELPERS PRIVADOS Y VALIDACION DE STOCK
    private Carrito obtenerOCrearCarrito(String username){
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(()->new UsuarioNotFoundException(username));
        return carritoRepository.findByUsuario(usuario)
                .orElseGet(()-> {
                    Carrito carrito = new Carrito();
                    carrito.setUsuario(usuario);
                    return carritoRepository.save(carrito);
                });
    }

    private CarritoDTO toDto(Carrito carrito){
        List<CarritoItemDTO> items = carrito.getItems().stream()
                .map(this::toItemDto).toList();
        Double total = items.stream()
                .mapToDouble(CarritoItemDTO::getSubtotal).sum();
        return new CarritoDTO(carrito.getId(), items, total);
    }

    private CarritoItemDTO toItemDto(CarritoItem item){
        Double precio = item.getProducto().getPrecio();
        return new CarritoItemDTO(
                item.getId(),
                item.getProducto().getId(),
                item.getProducto().getNombre(),
                precio,
                item.getCantidad(),
                precio * item.getCantidad());
    }

    private void validarStock(Producto producto, int cantidadSolicitada){
        if (cantidadSolicitada> producto.getStock()){
            throw new StockInsuficienteException("Stock insuficiente para '" + producto.getNombre()
            + "': disponible " + producto.getStock() +", solicitado "+ cantidadSolicitada);
        }
    }

    //METODOS PUBLICOS CRUD

    public CarritoDTO getCarrito(String username){
        return toDto(obtenerOCrearCarrito(username));
    }

    public CarritoDTO addItem(String username, CarritoItemCreateDTO dto){
        Carrito carrito = obtenerOCrearCarrito(username);
        Producto producto = productoRepository.findById(dto.getProductoId())
                .orElseThrow(()-> new ProductoNotFoundException(dto.getProductoId()));
        if(!producto.isActivo()){
            throw new ProductoNotFoundException(producto.getId());
        }
        int actual = carritoItemRepository.findByCarritoAndProducto(carrito, producto)
                .map(CarritoItem::getCantidad).orElse(0);
        int nuevaCantidad = actual + dto.getCantidad();
        validarStock(producto,nuevaCantidad);
        CarritoItem item = carritoItemRepository.findByCarritoAndProducto(carrito, producto)
                .orElseGet(()->{
                    CarritoItem nuevo = new CarritoItem();
                    nuevo.setCarrito(carrito);
                    nuevo.setProducto(producto);
                    carrito.getItems().add(nuevo);
                    return nuevo;
                });
        item.setCantidad(nuevaCantidad);
        carritoItemRepository.save(item);
        return toDto(carrito);
    }

    public CarritoDTO updateItem(String username, UUID itemId, CarritoItemUpdateDTO dto){
        Carrito carrito = obtenerOCrearCarrito(username);
        CarritoItem item = carritoItemRepository.findById(itemId)
                .orElseThrow(()->new CarritoItemNotFoundException(itemId));
        if(!item.getCarrito().getId().equals(carrito.getId())){
            //Si el id del item no es el mismo que el id del carrito lanza exception para que no entren items a otro carrito
            throw new CarritoItemNotFoundException(itemId);
        }
        validarStock(item.getProducto(), dto.getCantidad());
        item.setCantidad(dto.getCantidad());
        carritoItemRepository.save(item);
        return toDto(carrito);
    }

    public CarritoDTO removeItem(String username, UUID itemId){
        Carrito carrito = obtenerOCrearCarrito(username);
        CarritoItem item = carritoItemRepository.findById(itemId)
                .orElseThrow(()-> new CarritoItemNotFoundException(itemId));
        if(!item.getCarrito().getId().equals(carrito.getId())){
            throw new CarritoItemNotFoundException(itemId);
        }
        carrito.getItems().remove(item);
        return toDto(carrito);
    }

    public void vaciarCarrito(Carrito carrito){
        carrito.getItems().clear();
    }
}
