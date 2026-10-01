package com.example.E_commerce.ejercicio3.service;

import com.example.E_commerce.ejercicio3.DTO.ProductoCreateDTO;
import com.example.E_commerce.ejercicio3.DTO.ProductoDTO;
import com.example.E_commerce.ejercicio3.exception.ProductoNotFoundException;
import com.example.E_commerce.ejercicio3.model.Producto;
import com.example.E_commerce.ejercicio3.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/*
Servicio de la capa de negocio encargado de la gestión de productos en el E-commerce.
Realiza las operaciones CRUD, transformaciones a DTO y lógica de borrado lógico (soft delete).
y en la parte de abajo se explica cada uno de los metodos relacionados:
    -Inyección de dependencias por constructor del repositorio de productos.
    -toDto: Obtiene el listado de todos los productos registrados y los transforma a DTO.
    -findAllActivos: Obtiene el listado de todos los productos registrados y los transforma a DTO.
    -findById: Busca un producto por su identificador único UUID.
    -create: Registra un nuevo producto en la base de datos a partir de los datos recibidos en el DTO de creación.
    -update: Actualiza la información de un producto existente por su ID.
    -delete: Realiza un borrado lógico (soft delete) del producto, cambiando su estado
    en lugar de eliminar el registro físicamente de la base de datos.
*/
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    private ProductoDTO toDto(Producto producto){
        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.isActivo()
        );
    }

    public List<ProductoDTO> findAllActivos(){
        return productoRepository.findByActivoTrue().stream()
                .map(this::toDto).toList();
    }
    public ProductoDTO findById(UUID id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new ProductoNotFoundException(id));
        return toDto(producto);
    }
    public ProductoDTO create(ProductoCreateDTO dto){
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        return toDto(productoRepository.save(producto));
    }

    public ProductoDTO update(UUID id, ProductoCreateDTO dto){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()->new ProductoNotFoundException(id));
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        return toDto(productoRepository.save(producto));
    }

    public void delete(UUID id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new ProductoNotFoundException(id));
        producto.setActivo(false);
        productoRepository.save(producto);
    }
}
