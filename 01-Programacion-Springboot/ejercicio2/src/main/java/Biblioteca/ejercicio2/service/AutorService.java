package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.AutorCreateDTO;
import Biblioteca.ejercicio2.DTO.AutorDTO;
import Biblioteca.ejercicio2.exception.AutorNotFoundException;
import Biblioteca.ejercicio2.model.Autor;
import Biblioteca.ejercicio2.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
/**
 * Servicio para gestionar autores.
 * Contiene la lógica de negocio para CRUD de autores.
 */
@Service
public class AutorService {
    private final AutorRepository autorRepository;
    private AutorDTO toDTO(Autor autor){
        return new AutorDTO(autor.getId(), autor.getNombre());
    }
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorDTO> findAll(){
        return autorRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public AutorDTO findById(UUID id) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new AutorNotFoundException(id));
        return toDTO(autor);
    }
    public AutorDTO create(AutorCreateDTO dto){
        Autor autor = new Autor();
        autor.setNombre(dto.getNombre());
        return toDTO(autorRepository.save(autor));
    }

}
