INSERT INTO clases (nombre, descripcion, dado_vida, salvacion_1, salvacion_2) VALUES
('Hechicero', 'Fuego y magia y esas cosas', 4, 4, 5),
('Mago', 'Viejo y sabio', 4, 2, 1),
('Brujo', 'Conoce las artes oscuras', 4, 2, 1),
('Explorador', 'Hostiga desde la distancia', 5, 3, 1),
('Guerrero', 'Combate cuerpo a cuerpo', 7, 5, 1),
('Pícaro', 'Roba a humanoides y desactiva trampas', 4, 2, 1);




INSERT INTO razas ("id", "id_raza_padre", "nombre", "descripcion", "velocidad_a_pie", "velocidad_nado", "velocidad_vuelo", "ventajas", "idiomas", "altura") VALUES (1, NULL, 'Gnomo', 'Bajito y regordete, mazo viejo', 25, 10, 0, 'Ser superior', 'Comun y Gnomo', '0.8 - 1.2');
INSERT INTO razas ("id", "id_raza_padre", "nombre", "descripcion", "velocidad_a_pie", "velocidad_nado", "velocidad_vuelo", "ventajas", "idiomas", "altura") VALUES (2, 1, 'Gnomo leproso', 'En una piscina se convierte en aspirina', 15, 10, 0, 'Ser superior', 'Comun y Gnomo', '0.8 - 1.2');
INSERT INTO razas ("id", "id_raza_padre", "nombre", "descripcion", "velocidad_a_pie", "velocidad_nado", "velocidad_vuelo", "ventajas", "idiomas", "altura") VALUES (3, 1, 'Gnomo de piedra', 'He''s rock solid', 20, 10, 0, 'Ser superior', 'Comun y Gnomo', '0.8 - 1.2');
INSERT INTO razas ("id", "id_raza_padre", "nombre", "descripcion", "velocidad_a_pie", "velocidad_nado", "velocidad_vuelo", "ventajas", "idiomas", "altura") VALUES (4, NULL, 'Humano', 'Descripción del humano', 30, 10, 0, 'Negociación', 'Común y Humano', '1.6-1.9');
INSERT INTO razas ("id", "id_raza_padre", "nombre", "descripcion", "velocidad_a_pie", "velocidad_nado", "velocidad_vuelo", "ventajas", "idiomas", "altura") VALUES (5, NULL, 'Elfo', 'Orejas puntiagudas y alto', 35, 10, 0, 'Immortalidad', 'Común y élfico', '1.7-2.1');


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

INSERT INTO public.armas(
	id_objeto, clase, dano1, dano2)
	VALUES (2, 'finesse', 5, 2);

INSERT INTO public.armaduras(
	id_objeto, clase, defensa, bonus)
	VALUES (1, 'ligera', 12, ''),
	(4, 'magos', 8, 'ventaja en constitucion');	
		
INSERT INTO public.objetos_comunes(
	id_objeto, efecto)
	VALUES (3, 'cura 50'),
	(5, '10 dano');
	
INSERT INTO public.hechizos(
	id, nombre, descripcion, rango, tiempo_canalizacion, duracion, coste, nivel)
	VALUES (1, 'Alarma', 'Activas una alarma contra intrusos. Elige una puerta, ventana o área dentro del alcance que no tenga más de 20 pies cúbicos. Hasta que el conjuro termine, una alarma te alerta cuando una criatura Diminuta o mayor toca o entra en el área protegida', 30, '1 min', '8 h', 'V, S, M (una campanilla y un alambre de plata fina)', 1),
	(2, 'Bola fuego', 'Lanzas una bola de fuego. Todas las criaturas que se encuentren en una esfera de 20 pies de radio cuyo centro sea ese punto deben hacer una tirada de salvación de Destreza: si fallan, reciben 8d6 puntos de daño por fuego y, si tienen éxito, la mitad.', 150, '1 accion', 'Instantaneo', 'V, S, M (un bolita de guano de murciélago y azufre)', 3),
	(3, 'Agarre electrizante', 'Un rayo surge de tu mano para golpear a una criatura que estás intentando tocar.', 0, '1 accion', 'Instantaneo', 'V, S', 0),
    (4, 'Invocar demonio', 'Satanist shit', 20, '1 accion', 'Instantaneo', 'V, M', 2);

	
INSERT INTO public.hechizos_aprendidos(
	id_personaje, id_hechizo)
	VALUES (1, 2);	
INSERT INTO public.hechizos_clase(
	id_clase, id_hechizo)
	VALUES (1, 1),(1,2),(1,3);
