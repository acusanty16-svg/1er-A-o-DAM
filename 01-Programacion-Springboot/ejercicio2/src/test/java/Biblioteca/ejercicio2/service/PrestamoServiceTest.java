package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.PrestamoCreateDTO;
import Biblioteca.ejercicio2.DTO.PrestamosDTO;
import Biblioteca.ejercicio2.config.BibliotecaConfig;
import Biblioteca.ejercicio2.exception.LibroNotFoundException;
import Biblioteca.ejercicio2.exception.PrestamoNotFoundException;
import Biblioteca.ejercicio2.model.Libro;
import Biblioteca.ejercicio2.model.Prestamo;
import Biblioteca.ejercicio2.repository.LibroRepository;
import Biblioteca.ejercicio2.repository.PrestamosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PrestamoServiceTest {

    @Mock
    private PrestamosRepository prestamosRepository;

    @Mock
    private LibroRepository libroRepository;

    @Mock
    private BibliotecaConfig bibliotecaConfig;

    @InjectMocks
    private PrestamoService prestamoService;

    @Test
    void findAll_deberiaRetornarListaDePrestamos(){
        when(prestamosRepository.findAll()).thenReturn(List.of());

        List<PrestamosDTO> resultado = prestamoService.findAll();

        assertNotNull(resultado);
        assertTrue(resultado.isEmpty());
        verify(prestamosRepository, times(1)).findAll();
    }

    @Test
    void findById_deberiaRetornarPrestamosCuandoExiste(){
        UUID prestamoId = UUID.randomUUID();
        UUID libroId = UUID.randomUUID();

        Libro libro = new Libro();
        libro.setId(libroId);
        libro.setTitulo("Rayuela");
        libro.setPrestado(true);

        Prestamo prestamo = new Prestamo();
        prestamo.setId(prestamoId);
        prestamo.setUsuario("Juan");
        prestamo.setFechaPrestamo(LocalDateTime.now());
        prestamo.setLibro(libro);

        when(prestamosRepository.findById(prestamoId)).thenReturn(Optional.of(prestamo));

        PrestamosDTO resultado = prestamoService.findById(prestamoId);

        assertNotNull(resultado);
        assertEquals("Juan", resultado.getUsuario());
        assertEquals("Rayuela", resultado.getLibroTitulo());
        assertEquals(libroId, resultado.getIdLibro());
    }

    @Test
    void findById_deberiaLanzarExcepcionCuandoNoExiste() {
        UUID id = UUID.randomUUID();
        when(prestamosRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(PrestamoNotFoundException.class, () -> prestamoService.findById(id));
    }

    @Test
    void create_deberiaCrearPrestamoCuandoLibroDisponible() {
        UUID libroId = UUID.randomUUID();
        PrestamoCreateDTO dto = new PrestamoCreateDTO(libroId, "María");

        Libro libro = new Libro();
        libro.setId(libroId);
        libro.setTitulo("Cien Años de Soledad");
        libro.setPrestado(false);

        Prestamo prestamoGuardado = new Prestamo();
        prestamoGuardado.setId(UUID.randomUUID());
        prestamoGuardado.setUsuario("María");
        prestamoGuardado.setFechaPrestamo(LocalDateTime.now());
        prestamoGuardado.setLibro(libro);

        when(bibliotecaConfig.getMaxPrestamos()).thenReturn(5);
        when(prestamosRepository.count()).thenReturn(2L);
        when(libroRepository.findById(libroId)).thenReturn(Optional.of(libro));
        when(prestamosRepository.save(any(Prestamo.class))).thenReturn(prestamoGuardado);

        PrestamosDTO resultado = prestamoService.create(dto);

        assertNotNull(resultado);
        assertEquals("María", resultado.getUsuario());
        assertTrue(libro.isPrestado());
        verify(libroRepository, times(1)).save(libro);
        verify(prestamosRepository, times(1)).save(any(Prestamo.class));
    }


    @Test
    void create_deberiaLanzarExcepcionCuandoLimiteAlcanzado() {
        when(prestamosRepository.count()).thenReturn(5L);

        PrestamoCreateDTO dto = new PrestamoCreateDTO(UUID.randomUUID(), "Pedro");

        when(bibliotecaConfig.getMaxPrestamos()).thenReturn(5);

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> prestamoService.create(dto));
        assertTrue(exception.getMessage().contains("Limite de prestamos alcanzado"));
    }

    @Test
    void create_deberiaLanzarExceptionCuandoLibroNoExiste(){
        when(bibliotecaConfig.getMaxPrestamos()).thenReturn(5);
        UUID libroId = UUID.randomUUID();
        PrestamoCreateDTO dto = new PrestamoCreateDTO(libroId, "Ana");

        when(prestamosRepository.count()).thenReturn(2L);
        when(libroRepository.findById(libroId)).thenReturn(Optional.empty());

        assertThrows(LibroNotFoundException.class, ()->prestamoService.create(dto));
    }

    @Test
    void create_deberiaLanzarExceptionCuandoLibroYaPrestado(){
        UUID libroId = UUID.randomUUID();
        PrestamoCreateDTO dto = new PrestamoCreateDTO(libroId, "Carlos");

        Libro libro = new Libro();
        libro.setId(libroId);
        libro.setTitulo("Rayuela");
        libro.setPrestado(true);

        when(bibliotecaConfig.getMaxPrestamos()).thenReturn(5);
        when(prestamosRepository.count()).thenReturn(2L);
        when(libroRepository.findById(libroId)).thenReturn(Optional.of(libro));

        RuntimeException exception = assertThrows(RuntimeException.class, ()-> prestamoService.create(dto));

        assertTrue(exception.getMessage().contains("libro ya esta prestado"));

    }

    @Test
    void devolverLibro_deberiaDevolverLibroComoDisponible(){
        UUID libroId = UUID.randomUUID();
        UUID prestamoId = UUID.randomUUID();

        Libro libro = new Libro();
        libro.setTitulo("Rayuela");
        libro.setId(libroId);
        libro.setPrestado(true);

        Prestamo prestamo = new Prestamo();
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(LocalDateTime.now().minusDays(7));
        prestamo.setUsuario("Juan");
        prestamo.setId(prestamoId);

        when(prestamosRepository.findById(prestamoId)).thenReturn(Optional.of(prestamo));

        prestamoService.devolverLibro(prestamoId);

        assertFalse(libro.isPrestado());
        assertNotNull(prestamo.getFechaDevolucion());
        verify(libroRepository, times(1)).save(libro);
        verify(prestamosRepository, times(1)).save(prestamo);
    }

}
