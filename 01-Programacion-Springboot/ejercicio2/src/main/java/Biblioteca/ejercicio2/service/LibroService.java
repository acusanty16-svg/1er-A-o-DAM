package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.LibroCreateDTO;
import Biblioteca.ejercicio2.DTO.LibroDTO;
import Biblioteca.ejercicio2.exception.AutorNotFoundException;
import Biblioteca.ejercicio2.exception.LibroNotFoundException;
import Biblioteca.ejercicio2.model.Autor;
import Biblioteca.ejercicio2.model.Libro;
import Biblioteca.ejercicio2.repository.AutorRepository;
import Biblioteca.ejercicio2.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/**
 * Servicio para gestionar libros.
 * Contiene la lógica de negocio para CRUD de libros.
 */

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private LibroDTO toDTO (Libro libro){
        return new LibroDTO(
                libro.getId(),
                libro.getTitulo(),
                libro.getPrecio(),
                libro.isPrestado(),
                libro.getAutor().getId(),
                libro.getAutor().getNombre());
    }
    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public List<LibroDTO> findAll(){
        return libroRepository.findAll().stream()
                .map(this::toDTO).toList();
    }

    public LibroDTO findById(UUID id){
        Libro libro = libroRepository.findById(id)
                .orElseThrow(()-> new LibroNotFoundException(id));
        return toDTO(libro);
    }

    public LibroDTO create(LibroCreateDTO dto){
        Autor autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(()-> new AutorNotFoundException(dto.getAutorId()));
        Libro libro = new Libro();
        libro.setTitulo(dto.getTitulo());
        libro.setPrecio(dto.getPrecio());
        libro.setAutor(autor);
        return toDTO(libroRepository.save(libro));
    }
}
