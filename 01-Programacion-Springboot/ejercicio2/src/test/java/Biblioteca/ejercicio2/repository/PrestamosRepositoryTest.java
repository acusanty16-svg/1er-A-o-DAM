package Biblioteca.ejercicio2.repository;

import Biblioteca.ejercicio2.model.Autor;
import Biblioteca.ejercicio2.model.Libro;
import Biblioteca.ejercicio2.model.Prestamo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PrestamosRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PrestamosRepository prestamosRepository;

    // Método helper para crear escenario completo
    private Prestamo crearPrestamoConDatos(String username) {
        // 1. Autor
        Autor autor = new Autor();
        autor.setNombre("Gabriel García Márquez");
        entityManager.persistAndFlush(autor);

        // 2. Libro (con autor)
        Libro libro = new Libro();
        libro.setTitulo("Cien años de soledad");
        libro.setPrecio(19.99);
        libro.setAutor(autor);
        libro.setPrestado(false);
        entityManager.persistAndFlush(libro);

        // 3. Prestamo (con libro + username string)
        Prestamo prestamo = new Prestamo();
        prestamo.setUsuario(username);
        prestamo.setFechaPrestamo(LocalDateTime.now());
        prestamo.setLibro(libro);
        entityManager.persistAndFlush(prestamo);

        return prestamo;
    }

    @Test
    void count_deberiaRetornarNumeroCorrecto(){
        //ARRANGE
        crearPrestamoConDatos("juan");
        crearPrestamoConDatos("maria");
        crearPrestamoConDatos("pedro");

        //ACT
        long total = prestamosRepository.count();

        //ASSERT
        assertEquals(3, total);
    }

    @Test
    void findById_deberiaRetornarPrestamoCuandoExiste(){
        //ARRANGE
        Prestamo prestamo = crearPrestamoConDatos("juan");
        UUID id = prestamo.getId();

        //ACT
        Optional<Prestamo> resultado = prestamosRepository.findById(id);

        //ASSERT
        assertTrue(resultado.isPresent());
        Prestamo p = resultado.get();
        assertEquals("juan",p.getUsuario());
        assertNotNull(p.getFechaPrestamo());
        assertNotNull(p.getLibro());
        assertEquals("Cien años de soledad",p.getLibro().getTitulo());
        assertEquals(id,p.getId());
    }

    @Test
    void findById_deberiaRetornarEmptyCuandoNoExiste(){
        //ARRANGE
        UUID id = UUID.randomUUID();

        //ACT
        Optional<Prestamo> resultado = prestamosRepository.findById(id);

        //ASSERT
        assertTrue(resultado.isEmpty());
    }

    @Test
    void save_deberiaPersistirYAsignarId(){
        // ARRANGE
        Autor autor = new Autor();
        autor.setNombre("Isabel Allende");
        entityManager.persistAndFlush(autor);

        Libro libro = new Libro();
        libro.setTitulo("La casa de los espíritus");
        libro.setPrecio(17.99);
        libro.setAutor(autor);
        libro.setPrestado(false);
        entityManager.persistAndFlush(libro);

        Prestamo nuevo = new Prestamo();
        nuevo.setUsuario("ana");
        nuevo.setFechaPrestamo(LocalDateTime.now());
        nuevo.setLibro(libro);
        // ID es null aquí

        //ACT
        Prestamo guardado = prestamosRepository.save(nuevo);

        //ASSERT
        assertNotNull(guardado.getId());
        assertEquals("ana", guardado.getUsuario());
        assertNotNull(guardado.getFechaPrestamo());
        assertNotNull(guardado.getLibro());
        assertEquals(libro.getId(), guardado.getLibro().getId());

    }

    @Test
    void findAll_deberiaRetornarTodosLosPrestamos(){
        //ARRANGE
        crearPrestamoConDatos("juan");
        crearPrestamoConDatos("maria");

        //ACT
        List<Prestamo> resultado = prestamosRepository.findAll();

        //ASSERT
        assertEquals(2,resultado.size());

        //VERIFY
        assertTrue(resultado.stream().anyMatch(p -> "juan".equals(p.getUsuario())));
        assertTrue(resultado.stream().anyMatch(p -> "maria".equals(p.getUsuario())));

    }

    @Test
    void deleteById_deberiaEliminarPrestamo(){
        //ARRANGE
        Prestamo prestamo = crearPrestamoConDatos("juan");
        UUID id = prestamo.getId();

        //ACT
        prestamosRepository.deleteById(id);

        //ASSERT
        Optional<Prestamo> resultado = prestamosRepository.findById(id);
        assertTrue(resultado.isEmpty());
        assertEquals(0,prestamosRepository.count());
    }
}
