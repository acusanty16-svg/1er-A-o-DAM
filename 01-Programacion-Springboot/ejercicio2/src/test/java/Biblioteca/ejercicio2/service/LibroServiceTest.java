package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.LibroCreateDTO;
import Biblioteca.ejercicio2.DTO.LibroDTO;
import Biblioteca.ejercicio2.exception.AutorNotFoundException;
import Biblioteca.ejercicio2.exception.LibroNotFoundException;
import Biblioteca.ejercicio2.model.Autor;
import Biblioteca.ejercicio2.model.Libro;
import Biblioteca.ejercicio2.repository.AutorRepository;
import Biblioteca.ejercicio2.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibroServiceTest {

    @Mock
    private LibroRepository libroRepository;

    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private LibroService libroService;

    @Test
    void findAll_deberiaRetornarListaDeLibros(){
        UUID autorId = UUID.randomUUID();
        Autor autor = new Autor();
        autor.setId(autorId);
        autor.setNombre("Cortázar");

        Libro libro1 = new Libro();
        libro1.setId(UUID.randomUUID());
        libro1.setTitulo("Rayuela");
        libro1.setPrecio(15.99);
        libro1.setAutor(autor);

        Libro libro2 = new Libro();
        libro2.setId(UUID.randomUUID());
        libro2.setTitulo("Bestiario");
        libro2.setPrecio(12.99);
        libro2.setAutor(autor);

        when(libroRepository.findAll()).thenReturn(List.of(libro1, libro2));

        List<LibroDTO> resultado = libroService.findAll();

        assertEquals(2,resultado.size());
        assertEquals("Rayuela",resultado.get(0).getTitulo());
        assertEquals("Bestiario",resultado.get(1).getTitulo());
    }

    @Test
    void findById_deberiaRetornarLibroCuandoExiste(){
        UUID id = UUID.randomUUID();
        UUID autorID = UUID.randomUUID();
        Autor autor = new Autor();
        autor.setId(autorID);
        autor.setNombre("Allende");

        Libro libro = new Libro();
        libro.setId(id);
        libro.setTitulo("La casa de los Espiritus");
        libro.setPrecio(17.99);
        libro.setAutor(autor);

        when(libroRepository.findById(id)).thenReturn(Optional.of(libro));

        LibroDTO resultado = libroService.findById(id);

        assertNotNull(resultado);
        assertEquals("La casa de los Espiritus",resultado.getTitulo());
    }

    @Test
    void findById_deberiaRetornarExcepcionCuandoNoExiste(){
        UUID id = UUID.randomUUID();
        when(libroRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(LibroNotFoundException.class, ()->libroService.findById(id));
    }

    @Test
    void create_deberiaCrearLibroCuandoAutorExiste(){
        UUID autorId = UUID.randomUUID();
        Autor autor = new Autor();
        autor.setId(autorId);
        autor.setNombre("Neruda");

        LibroCreateDTO dto = new LibroCreateDTO("Veinte poemas de Amor", 9.99, autorId);

        Libro libroGuardado = new Libro();
        libroGuardado.setId(UUID.randomUUID());
        libroGuardado.setTitulo("Veinte poemas de Amor");
        libroGuardado.setPrecio(9.99);
        libroGuardado.setAutor(autor);

        when(autorRepository.findById(autorId)).thenReturn(Optional.of(autor));
        when(libroRepository.save(any(Libro.class))).thenReturn(libroGuardado);

        LibroDTO resultado = libroService.create(dto);

        assertNotNull(resultado);
        assertEquals("Veinte poemas de Amor", resultado.getTitulo());
        assertEquals(9.99, resultado.getPrecio());
        verify(libroRepository, times(1)).save(any(Libro.class));

    }

    @Test
    void create_deberiaLanzarUnaExcepcionCuandoAutorNoExiste(){
        UUID autorId = UUID.randomUUID();
        LibroCreateDTO dto = new LibroCreateDTO("Libro Fantasma", 10.00, autorId);

        when(autorRepository.findById(autorId)).thenReturn(Optional.empty());

        assertThrows(AutorNotFoundException.class, ()->libroService.create(dto));
    }
}
