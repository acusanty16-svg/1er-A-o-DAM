package Biblioteca.ejercicio2.controller;

import Biblioteca.ejercicio2.DTO.PrestamoCreateDTO;
import Biblioteca.ejercicio2.DTO.PrestamosDTO;
import Biblioteca.ejercicio2.service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador para gestionar préstamos.
 * Endpoints: GET /api/prestamos, POST /api/prestamos, PUT /api/prestamos/{id}/devolver
 */

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {
    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }
    @GetMapping
    public ResponseEntity<List<PrestamosDTO>> findAll(){
        return ResponseEntity.ok(prestamoService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PrestamosDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(prestamoService.findById(id));
    }
    @PostMapping
    public ResponseEntity<PrestamosDTO> create(@Valid @RequestBody PrestamoCreateDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(prestamoService.create(dto));
    }
    @PutMapping("/{id}/devolver")
    public ResponseEntity<Void> devolverLibro(@PathVariable UUID id){
        prestamoService.devolverLibro(id);
        return ResponseEntity.noContent().build();
    }
}
