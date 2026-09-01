package Biblioteca.ejercicio2.controller;

import Biblioteca.ejercicio2.DTO.LibroCreateDTO;
import Biblioteca.ejercicio2.DTO.LibroDTO;
import Biblioteca.ejercicio2.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador para gestionar libros.
 * Endpoints: GET /api/libros, POST /api/libros, GET /api/libros/{id}
 */

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }
    @GetMapping
    public ResponseEntity<List<LibroDTO>> findAll(){
        return ResponseEntity.ok(libroService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(libroService.findById(id));
    }
    @PostMapping
    public ResponseEntity<LibroDTO> create(@Valid @RequestBody LibroCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.create(dto));
    }
}
