package com.example.ejercicio1_hola_mundo.controller;

import com.example.ejercicio1_hola_mundo.dto.ProductoCreateDTO;
import com.example.ejercicio1_hola_mundo.dto.ProductoDTO;
import com.example.ejercicio1_hola_mundo.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador REST para gestionar productos.
 * Todas las rutas empiezan con /api/productos.
 * Usa @Valid para activar las validaciones del DTO antes de procesar la petición.
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    // GET /api/productos -> lista todos los productos
    @GetMapping
    public List<ProductoDTO> listar() {
        return service.listar();
    }

    // GET /api/productos/{id} -> obtiene un producto por su ID
    @GetMapping("/{id}")
    public ProductoDTO obtener(@PathVariable UUID id) {
        return service.obtenerPorId(id);
    }

    // POST /api/productos -> crea un producto nuevo (devuelve 201 Created)
    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@Valid @RequestBody ProductoCreateDTO dto) {
        ProductoDTO creado = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/productos/{id} -> actualiza un producto existente
    @PutMapping("/{id}")
    public ProductoDTO actualizar(@PathVariable UUID id, @Valid @RequestBody ProductoCreateDTO dto) {
        return service.actualizar(id, dto);
    }

    // DELETE /api/productos/{id} -> elimina un producto (devuelve 204 No Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable UUID id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
