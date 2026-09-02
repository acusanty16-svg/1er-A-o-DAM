-- ============================================
-- DATOS DE PRUEBA: Biblioteca
-- Este archivo se ejecuta automáticamente al arrancar la app
-- gracias a spring.sql.init.mode: always en application.yml
-- ============================================

-- Autores (5 autores)
INSERT INTO autores (id, nombre) VALUES (gen_random_uuid(), 'Gabriel Garcia Marquez');
INSERT INTO autores (id, nombre) VALUES (gen_random_uuid(), 'Mario Vargas Llosa');
INSERT INTO autores (id, nombre) VALUES (gen_random_uuid(), 'Julio Cortazar');
INSERT INTO autores (id, nombre) VALUES (gen_random_uuid(), 'Isabel Allende');
INSERT INTO autores (id, nombre) VALUES (gen_random_uuid(), 'Pablo Neruda');

-- Libros (10 libros, 2 por autor)
INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Cien Anos de Soledad', 19.99, false, (SELECT id FROM autores WHERE nombre = 'Gabriel Garcia Marquez'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Cronica de una Muerte Anunciada', 14.99, false, (SELECT id FROM autores WHERE nombre = 'Gabriel Garcia Marquez'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'La Ciudad y los Perros', 16.99, false, (SELECT id FROM autores WHERE nombre = 'Mario Vargas Llosa'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Conversacion en La Catedral', 18.99, false, (SELECT id FROM autores WHERE nombre = 'Mario Vargas Llosa'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Rayuela', 15.99, false, (SELECT id FROM autores WHERE nombre = 'Julio Cortazar'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Bestiario', 12.99, false, (SELECT id FROM autores WHERE nombre = 'Julio Cortazar'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'La Casa de los Espiritus', 17.99, false, (SELECT id FROM autores WHERE nombre = 'Isabel Allende'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Paula', 13.99, false, (SELECT id FROM autores WHERE nombre = 'Isabel Allende'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Veinte Poemas de Amor', 9.99, false, (SELECT id FROM autores WHERE nombre = 'Pablo Neruda'));

INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Cien Sonetos de Amor', 11.99, false, (SELECT id FROM autores WHERE nombre = 'Pablo Neruda'));

-- Usuarios de prueba (contraseña: "password123" cifrada con BCrypt)
INSERT INTO usuarios (id, username, password, email, role)
VALUES (gen_random_uuid(), 'admin', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'admin@biblioteca.com', 'ROLE_ADMIN');

INSERT INTO usuarios (id, username, password, email, role)
VALUES (gen_random_uuid(), 'usuario', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', 'usuario@biblioteca.com', 'ROLE_USER');