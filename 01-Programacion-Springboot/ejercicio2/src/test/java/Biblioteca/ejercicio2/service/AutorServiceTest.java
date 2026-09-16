package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.AutorCreateDTO;
import Biblioteca.ejercicio2.DTO.AutorDTO;
import Biblioteca.ejercicio2.exception.AutorNotFoundException;
import Biblioteca.ejercicio2.model.Autor;
import Biblioteca.ejercicio2.repository.AutorRepository;
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
class AutorServiceTest{
    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private AutorService autorService;

    @Test
    void findAll_deberiaRetornarListaDeAutores(){
        //Arrange (preparar)
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        Autor autor1 = new Autor();
        autor1.setId(id1);
        autor1.setNombre("García Márquez");

        Autor autor2 = new Autor();
        autor2.setId(id2);
        autor2.setNombre("Cortázar");

        when(autorRepository.findAll()).thenReturn(List.of(autor1,autor2));

        //Act (ejecutar)
        List<AutorDTO> resultado = autorService.findAll();

        //Assert (verificar)
        assertEquals(2,resultado.size());
        assertEquals("García Márquez",resultado.get(0).getNombre());
        assertEquals("Cortázar",resultado.get(1).getNombre());
        verify(autorRepository, times(1)).findAll();
    }

    @Test
    void findByID_deberiaRetornarAutorCuandoExiste(){
        //Arrange
        UUID id = UUID.randomUUID();
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNombre("Vargas Llosa");

        when(autorRepository.findById(id)).thenReturn(Optional.of(autor));

        //Act
        AutorDTO resultado = autorService.findById(id);

        //Asserts
        assertNotNull(resultado);
        assertEquals("Vargas Llosa",resultado.getNombre());
        assertEquals(id,resultado.getId());
    }

    @Test
    void findById_deberiaRetornarExcepcionCuandoExiste(){
        //Arrange
        UUID id = UUID.randomUUID();
        when(autorRepository.findById(id)).thenReturn(Optional.empty());

        //Act y Assert
        assertThrows(AutorNotFoundException.class, ()->autorService.findById(id));
    }

    @Test
    void create_deberiaCrearYRetornarAutor(){
        AutorCreateDTO dto = new AutorCreateDTO("Pablo Neruda");
        Autor autorGuardado = new Autor();
        autorGuardado.setId(UUID.randomUUID());
        autorGuardado.setNombre("Pablo Neruda");

        when(autorRepository.save(any(Autor.class))).thenReturn(autorGuardado);

        //Act
        AutorDTO resultado = autorService.create(dto);

        //Assert
        assertNotNull(resultado);
        assertEquals("Pablo Neruda", resultado.getNombre());
        verify(autorRepository, times(1)).save(any(Autor.class));
    }

}