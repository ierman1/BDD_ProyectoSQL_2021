INSERT INTO clases (nombre, descripcion, dado_vida, salvacion_1, salvacion_2) VALUES
('Hechicero', 'Fuego y magia y esas cosas', 4, 4, 5),
('Hechicero', 'Fuego y magia y esas cosas', 4, 4, 5),
('Hechicero', 'Fuego y magia y esas cosas', 4, 4, 5),
('Hechicero', 'Fuego y magia y esas cosas', 4, 4, 5),
('Hechicero', 'Fuego y magia y esas cosas', 4, 4, 5),
('Hechicero', 'Fuego y magia y esas cosas', 4, 4, 5);

INSERT INTO razas (id_raza_padre, nombre, descripcion, velocidad_a_pie, velocidad_vuelo, velocidad_nado, ventajas, idiomas, altura) VALUES
(NULL, 'Gnomo', 'Bajito y regordete, mazo viejo', 25, 0, 10, 'Ser superior', 'Comun y Gnomo', '0.8 - 1.2'),
(NULL, 'Gnomo', 'Bajito y regordete, mazo viejo', 25, 0, 10, 'Ser superior', 'Comun y Gnomo', '0.8 - 1.2'),
(NULL, 'Gnomo', 'Bajito y regordete, mazo viejo', 25, 0, 10, 'Ser superior', 'Comun y Gnomo', '0.8 - 1.2');

INSERT INTO personajes (id_raza, id_clase, nombre, nivel, edad, altura, peso, vida_max, vida_actual, oro, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma) VALUES
(1, 1, 'Yoxi Ningel', 1, 50, 20, 1.0, 10, 10, 15, 2, 2, 4, 14, 8, 2),
(1, 1, 'Yoxi Ningel 2', 1, 50, 20, 1.0, 10, 10, 15, 2, 2, 4, 14, 8, 2),
(1, 1, 'Yoxi Ningel 3', 1, 50, 20, 1.0, 10, 10, 15, 2, 2, 4, 14, 8, 2),
(1, 1, 'Yoxi Ningel 4', 1, 50, 20, 1.0, 10, 10, 15, 2, 2, 4, 14, 8, 2);

INSERT INTO public.objetos(
	id, nombre, descripcion, peso, volumen, valor, equipable)
	VALUES (1, 'armadura', 'como una roca', 32, '2x2', 30, true),
	(2, 'espada', 'afilada', 22, '2x1', 15, true),
	(3, 'pocion cura', 'cura', 2, '2x2', 1, false),
	(4, 'toga', 'bata de ducha', 1, '2x2', 30, true),
	(5, 'veneno', 'ta feo', 2, '2x2', 45, false);
	
