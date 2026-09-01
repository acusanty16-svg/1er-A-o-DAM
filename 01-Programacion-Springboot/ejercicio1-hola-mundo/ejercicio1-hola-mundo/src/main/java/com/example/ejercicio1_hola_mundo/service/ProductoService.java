package com.example.ejercicio1_hola_mundo.service;

import com.example.ejercicio1_hola_mundo.dto.ProductoCreateDTO;
import com.example.ejercicio1_hola_mundo.exception.ProductoNotFoundException;
import com.example.ejercicio1_hola_mundo.dto.ProductoDTO;
import com.example.ejercicio1_hola_mundo.model.Producto;
import com.example.ejercicio1_hola_mundo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Servicio que gestiona la lógica de negocio de productos.
 * Se comunica con la base de datos a través del repositorio
 * y convierte entre entidades y DTOs.
 */
@Service
public class ProductoService {

    private final ProductoRepository repository;

    // Constructor injection: Spring pasa el repositorio automáticamente
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // Devuelve todos los productos convertidos a DTO
    public List<ProductoDTO> listar() {
        return repository.findAll()
                .stream().map(this::toDTO).toList();
    }

    // Busca un producto por ID, si no existe lanza excepción
    public ProductoDTO obtenerPorId(UUID id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        return toDTO(producto);
    }

    // Crea un nuevo producto con los datos del DTO
    public ProductoDTO crear(ProductoCreateDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        Producto guardado = repository.save(producto);
        return toDTO(guardado);
    }

    // Actualiza un producto existente con los nuevos datos
    public ProductoDTO actualizar(UUID id, ProductoCreateDTO dto) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException(id));
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        Producto actualizado = repository.save(producto);
        return toDTO(actualizado);
    }

    // Elimina un producto, primero verifica que exista
    public void eliminar(UUID id) {
        if (!repository.existsById(id)) {
            throw new ProductoNotFoundException(id);
        }
        repository.deleteById(id);
    }

    // Convierte una entidad a DTO (método auxiliar privado)
    private ProductoDTO toDTO(Producto producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        return dto;
    }
}
