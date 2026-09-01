-- ============================================
-- DATOS DE PRUEBA: 30 PRODUCTOS
-- Este archivo se ejecuta automáticamente al arrancar la app
-- gracias a spring.sql.init.mode: always en application.yml
-- ============================================

-- Electrónica (10 productos)
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Portatil Lenovo', 899.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Movil Samsung', 699.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Tablet iPad', 449.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Auriculares Sony', 129.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Raton Logitech', 39.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Teclado Mecanico', 79.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Monitor LG 27"', 349.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Disco Duro SSD 1TB', 89.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Memoria USB 64GB', 14.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Cargador Universal', 24.99);

-- Hogar (8 productos)
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Silla Ergonomica', 199.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Mesa de Escritorio', 249.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Lampara de Pie', 59.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Alfombra 2x3', 79.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Cuadro Abstracto', 45.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Reloj de Pared', 34.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Espejo Full Length', 89.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Estanteria 5 Levels', 129.99);

-- Ropa (7 productos)
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Camiseta Basica', 19.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Pantalon Jean', 49.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Zapatillas Running', 89.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Chaqueta Impermeable', 119.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Gorra Trucker', 15.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Bufanda Lana', 22.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Calcetines Pack 3', 9.99);

-- Deportes (5 productos)
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Balon Futbol', 29.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Raqueta Tenis', 79.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Bicicleta Montaña', 549.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Mancuernas 10kg', 44.99);
INSERT INTO productos (id, nombre, precio) VALUES (gen_random_uuid(), 'Colchoneta Yoga', 24.99);
