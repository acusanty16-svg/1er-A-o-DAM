package Biblioteca.ejercicio2.controller;

import Biblioteca.ejercicio2.DTO.AutorCreateDTO;
import Biblioteca.ejercicio2.DTO.AutorDTO;
import Biblioteca.ejercicio2.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador para gestionar autores.
 * Endpoints: GET /api/autores, POST /api/autores, GET /api/autores/{id}
 */

@RestController
@RequestMapping("api/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }
    @GetMapping
    public ResponseEntity<List<AutorDTO>> findAll(){
        return ResponseEntity.ok(autorService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(autorService.findById(id));
    }
    @PostMapping
    public ResponseEntity<AutorDTO> create(@Valid @RequestBody AutorCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.create(dto));
    }
}
