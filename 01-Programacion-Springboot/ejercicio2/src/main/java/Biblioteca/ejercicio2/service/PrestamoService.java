package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.PrestamoCreateDTO;
import Biblioteca.ejercicio2.DTO.PrestamosDTO;
import Biblioteca.ejercicio2.exception.LibroNotFoundException;
import Biblioteca.ejercicio2.exception.PrestamoNotFoundException;
import Biblioteca.ejercicio2.model.Libro;
import Biblioteca.ejercicio2.model.Prestamo;
import Biblioteca.ejercicio2.repository.LibroRepository;
import Biblioteca.ejercicio2.repository.PrestamosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Servicio para gestionar préstamos.
 * USA @Transactional porque prestar/devolver son operaciones que deben ejecutarse juntas.
 */

@Service
public class PrestamoService {
    private final PrestamosRepository prestamosRepository;
    private final LibroRepository libroRepository;
    private PrestamosDTO toDTO(Prestamo prestamo){
        return new PrestamosDTO(prestamo.getId(),
                prestamo.getUsuario(),
                prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucion(),
                prestamo.getLibro().getId(),
                prestamo.getLibro().getTitulo());
    }
    public PrestamoService(PrestamosRepository prestamosRepository, LibroRepository libroRepository) {
        this.prestamosRepository = prestamosRepository;
        this.libroRepository = libroRepository;
    }
    public List<PrestamosDTO> findAll(){
        return prestamosRepository.findAll().stream()
                .map(this::toDTO).toList();
    }
    public PrestamosDTO findById(UUID id){
        Prestamo prestamo = prestamosRepository.findById(id)
                .orElseThrow(()-> new PrestamoNotFoundException(id));
        return toDTO(prestamo);
    }
    @Transactional
    public PrestamosDTO create(PrestamoCreateDTO dto) {
        // Paso 1: Buscar el libro
        Libro libro = libroRepository.findById(dto.getLibroId())
                .orElseThrow(() -> new LibroNotFoundException(dto.getLibroId()));

        //Paso 2: Verificar que no esté prestado
        if(libro.isPrestado()){
            throw new RuntimeException("El libro ya esta prestado");
        }

        //Paso 3: Marcar el libro como prestado
        libro.setPrestado(true);
        libroRepository.save(libro);

        //Paso 4: Crear el registro del préstamo
        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setUsuario(dto.getUsuario());
        prestamo.setFechaPrestamo(LocalDateTime.now());

        //Si algo falla en cualquiera de los pasos, TODO se deshace
        return toDTO(prestamosRepository.save(prestamo));
    }

    @Transactional
    public void devolverLibro(UUID prestamosId){
        //Paso 1: Buscar el libro
        Prestamo prestamo = prestamosRepository.findById(prestamosId)
                .orElseThrow(()-> new PrestamoNotFoundException(prestamosId));

        //Paso 2: Marcar el libro como disponible
        Libro libro = prestamo.getLibro();
        libro.setPrestado(false);
        libroRepository.save(libro);

        //Paso 3: Registrar la fecha de la devolucion
        prestamo.setFechaDevolucion(LocalDateTime.now());
        prestamosRepository.save(prestamo);

        // Si algo falla, TODO se deshace
    }
}
