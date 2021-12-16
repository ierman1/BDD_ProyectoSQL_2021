ALTER SEQUENCE razas_id_seq RESTART WITH 1;
ALTER SEQUENCE personajes_id_seq RESTART WITH 1;
ALTER SEQUENCE hechizos_id_seq RESTART WITH 1;
ALTER SEQUENCE clases_id_seq RESTART WITH 1;
ALTER SEQUENCE packs_inciales_id_seq RESTART WITH 1;
ALTER SEQUENCE objetos_id_seq RESTART WITH 1;


truncate table hechizos_aprendidos, hechizos_raza, hechizos_clase, hechizos, objetos_packs_iniciales,clases, razas,packs_inciales, personajes, inventarios, hechizos_aprendidos,objetos_comunes, objetos,packs_inciales, armas, armaduras;
INSERT INTO clases (nombre, descripcion, dado_vida, salvacion_1, salvacion_2) VALUES
                                                                                  ('Barbaro', 'Para algunos, su rabia brota de la comunión con espíritus de animales salvajes. Otros recurren a su hirviente reserva de ira frente a un mundo lleno de dolor. Para los bárbaros, la furia es un poder que no sólo les proporciona un frenesí ciego en la batalla, sino también extraordinarios reflejos, resistencia y proezas de fuerza.', 12, 1, 3),
                                                                                  ('Bardo', 'Ya sea un erudito, un poeta o un canalla, un bardo teje su magia a través de sus palabras y su música para inspirar a los aliados, desmoralizar a los enemigos, manipular mentes, crear ilusiones e incluso sanar heridas.', 8, 2, 6),
                                                                                  ('Brujo', 'Los brujos son buscadores del conocimiento que se encuentra escondido en el multiverso. A través de pactos hechos con seres poderosos de poder sobrenatural, los brujos desatan efectos mágicos tanto sutiles como espectaculares y recolectan secretos arcanos para potenciar su propio poder.', 8, 5, 6),
                                                                                  ('Clérigo', 'Los clérigos son intermediarios entre el mundo mortal y los distantes planos divinos. Tan diferentes entre ellos como los dioses a los que sirven, los clérigos se esfuerzan por personificar las obras de sus deidades. No son sacerdotes ordinarios, un clérigo se encuentra imbuido de magia divina.', 8, 5, 6),
                                                                                  ('Druida', 'Ya sea invocando a las fuerzas elementales o emulando a las criaturas del mundo animal, los druidas son la personificación de la resistencia, astucia y furia de la naturaleza. Dicen no tener un dominio sobre la naturaleza. En lugar de eso, se ven como una extensión de la voluntad indomable de la misma.', 8, 4, 5),
                                                                                  ('Explorador', 'Lejos del bullicio de las ciudades y pueblos, más allá de las defensas que mantienen a las granjas más lejanas protegidas de los terrores de la naturaleza, en medio de tupidos bosques sin caminos y a través de enormes y vacías llanuras, los exploradores mantienen su interminable guardia.', 10, 1, 2),
                                                                                  ('Hechicero', 'Los magos son los practicantes supremos de la magia, definidos y unidos como una clase por los hechizos que conjuran. A partir de la sutil onda de la magia que impregna el cosmos, los magos lanzan explosivos hechizos de fuego, arcos voltaicos, sutiles engaños y brutales formas de control mental.', 6, 4, 5);
INSERT INTO razas (id_raza_padre, nombre, descripcion, velocidad_a_pie, velocidad_nado, velocidad_vuelo, ventajas, idiomas, altura) VALUES
                                                                                                                                        (NULL, 'Humano', 'En los registros de la mayoría de los mundos, los humanos son la más joven de las razas comunes. Han llegado comparativamente tarde al mundo y sus vidas son más cortas que las de enanos, elfos y dragones. Y quizá sea precisamente por estas breves existencias por lo que los humanos aspiran a conseguir tanto como sean capaces en los años que se les han concedido.', 30, 15, 0, '+1 Fuerza, Destreza, Constitución, Inteligencia, Sabiduría y Carisma', 'Puedes hablar, leer y escribir común y un idioma adicional de tu elección. Los humanos normalmente aprenden los idiomas de aquellos con los que se relacionan, aunque sean dialectos poco conocidos. Les gusta adornar su habla con palabras tomadas de otras lenguas: maldiciones orcas, expresiones musicales elfas, términos militares enanos, y así.', 'La altura y complexión de los humanos varían enormemente de un individuo a otro, midiendo entre un poco menos de 5 pies y algo más de 6 pies de altura. Independientemente de cual sea tu altura concreta, tu tamaño es Mediano.'),
                                                                                                                                        (NULL, 'Gnomo', 'Los gnomos son bienvenidos en todas partes como técnicos, alquimistas e inventores, pero muchos de ellos prefieren quedarse entre los suyos aunque sus habilidades estén muy demandadas. Viven en cómodas madrigueras excavadas bajo colinas onduladas y frondosas. Aunque en estos lugares abundan los animales, ir de caza es una pésima idea.', 25, 12.5, 0, 'Visión en la oscuridad. Astucia de gnomo. +2 Inteligencia.', 'Puedes hablar, leer y escribir común y gnomo. El idioma gnomo, que utiliza la grafía enana, es famoso por sus tratados técnicos y sus catálogos de conocimiento sobre el mundo natural.', 'Pequeños, 1m - 1.2m');
INSERT INTO razas (id_raza_padre, nombre, descripcion, velocidad_a_pie, velocidad_nado, velocidad_vuelo, ventajas, idiomas, altura) VALUES
                                                                                                                                        (2, 'Gnomo de las rocas', 'Como gnomo de las rocas, tienes una creatividad y una dureza naturales que superan las de otros gnomos.', 25, 12.5, 0, 'Conocimiento de artificiero. Constructor. +1 Constitución. Competencia: Herramientas de artesano.', 'Puedes hablar, leer y escribir común y gnomo. El idioma gnomo, que utiliza la grafía enana, es famoso por sus tratados técnicos y sus catálogos de conocimiento sobre el mundo natural.', 'Pequeños, 1m - 1.2m'),
                                                                                                                                        (NULL, 'Enano', 'Los enanos son conocidos por su habilidad en el arte de la guerra, su gran resistencia a los castigos, su conocimiento de los secretos de la tierra, su dedicación al trabajo y su capacidad para beber cerveza. Los enanos son gente poco dada a las risas o las bromas, y suelen mostrarse recelosos con los desconocidos; sin embargo, se comportan de forma generosa con los que se ganan su confianza.', 25, 12.5, 0, 'Visión en la oscuridad. Fortaleza enana. Afinidad con la piedra. +2 Constitución. Competencia: Hacha de mano, Hacha de batalla, Martillo de guerra y Martillo ligero', 'Puedes hablar, leer y escribir común y enano. El idioma enano está lleno de consonantes duras y sonidos guturales, características que se aplican también a cualquier otra lengua que hable un enano.', 'Pequeños, 1.2m - 1.4m');
INSERT INTO razas (id_raza_padre, nombre, descripcion, velocidad_a_pie, velocidad_nado, velocidad_vuelo, ventajas, idiomas, altura) VALUES
                                                                                                                                        (4, 'Enano de las colinas', 'Los enanos de las colinas tienen unos sentidos agudos, una gran intuición y una fortaleza increíble.', 25, 12.5, 0, '+1 Sabiduría. +(Nivel) Puntos de golpe adicionales', 'Puedes hablar, leer y escribir común y enano. El idioma enano está lleno de consonantes duras y sonidos guturales, características que se aplican también a cualquier otra lengua que hable un enano.', 'Pequeños, 1.2m - 1.4m'),
                                                                                                                                        (NULL, 'Semiorco', 'Tu personaje semiorco tiene ciertos rasgos que derivan de su ancestro orco. Los semiorcos heredan la tendencia hacia el caos de sus progenitores orcos y no están muy inclinados hacia el bien. Los semiorcos que se crían entre orcos y que permanecen entre ellos suelen ser malignos.', 30, 15, 0, 'Visión en la oscuridad. Resistencia implacable. Ataques salvajes. +2 Fuerza. Competencia: Intimidar', 'Puedes hablar, leer y escribir común y orco. El orco es un idioma áspero, chirriante y con consonantes duras. No tiene grafía propia, se escribe con la grafía enana.', 'Grandes, 1.8m - 2.1m');

INSERT INTO personajes (id_raza, id_clase, nombre, nivel, edad, altura, peso, vida_max, vida_actual, oro, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma) VALUES
                                                                                                                                                                                (3, 7, 'Yoxi Ningel', 1, 50, 1.0, 20, 10, 10, 15, 2, 2, 4, 14, 8, 2),
                                                                                                                                                                                (3, 7, 'Yoxi Ningel', 1, 50, 1.0, 20, 10, 10, 15, 2, 2, 4, 14, 8, 2);;


INSERT INTO objetos (id, nombre, descripcion, peso, volumen, valor, equipable) VALUES
                                                                                   (1, 'Mochila', 'Bolsa de cuero que se lleva a la espalda.', 5, '1x1', 2, FALSE),
                                                                                   (2, 'Saco de dormir', 'Nunca sabes donde vas a tener que dormir, el saco de dormir te ayuda a descansar.', 7, '1x2', 1, FALSE),
                                                                                   (3, 'Set de utensilios', 'Esta caja de latón contiene un bol y un conjunto de cubiertos.', 1, '1x1', 2, FALSE),
                                                                                   (4, 'Polvorín', 'Esta pequeña caja contiene un pedernal, un pedazo de hierro y madera seca para encender fuego.', 1, '1x1', 5, FALSE),
                                                                                   (5, 'Antorcha', 'Una antorcha que dura 1 hora e ilumina en un radio de 20 pies.', 1, '1x1', 1, TRUE),
                                                                                   (6, 'Raciones (1 día)', 'Las raciones consisten en comida seca para largos viajes.', 5, '1x1', 1, FALSE),
                                                                                   (7, 'Odre', 'Odre que puede contener 4 pintas de agua.', 5, '1x1', 2, FALSE),
                                                                                   (8, 'Cuerda (50 pies)', 'Cuerda con dos finales. Puede ser partida con una tirada de 17 fuerza.', 10, '2x2', 1, FALSE),
                                                                                   (9, 'Manta', 'Una manta preparada para protegerte del frío.', 5, '2x1', 1, FALSE),
                                                                                   (10, 'Vela', 'Vela que dura 1 hora e ilumina en un radio de 5 pies.', 1, '1x1', 1, FALSE),
                                                                                   (11, 'Caja para limosnas', 'Una pequeña caja para limosnas, típicamente encontrada en un pack de clérigos.', 1, '1x1', 1, FALSE),
                                                                                   (12, 'Bloque de incienso', 'Un bloque de incienso, típicamente encontrado en un pack de clérigos.', 1, '1x1', 1, FALSE),
                                                                                   (13, 'Incensario', 'Un incensario, típicamente encontrado en un pack de clérigos.', 1, '1x1', 1, FALSE),
                                                                                   (14, 'Vestimentas', 'Ropa de creyente, típicamente encontrada en un pack de clérigos.', 1, '1x1', 1, FALSE),
                                                                                   (15, 'Libro de historia', 'Un simple libro de historia.', 5, '1x1', 25, FALSE),
                                                                                   (16, 'Botella de tinta', 'Un vial con tinta, perfecto para escribas.', 1, '1x1', 1, FALSE),
                                                                                   (17, 'Lápiz de tinta', 'Un simple palo de madera con una punta especial.', 1, '1x1', 2, FALSE),
                                                                                   (18, 'Lámina de pergamino', 'Una lámina de pergamino vacía, perfecta para escribir en ella.', 1, '1x1', 1, FALSE),
                                                                                   (19, 'Bolsa de arena', 'Una pequeña bolsa de arena, típicamente encontrada en un pack de escriba.', 1, '1x1', 1, FALSE),
                                                                                   (20, 'Cuchillo pequeño', 'Una pequeña daga o cuchillo, típicamente encontrada en un pack de escriba.', 1, '1x1', 1, FALSE);

INSERT INTO armas(id_objeto, clase, dano1, dano2) VALUES (20, 'Daga', 5, 2);
INSERT INTO armaduras(id_objeto, clase, defensa, bonus) VALUES (14, 'Ligera', 12, '+1 Sabiduría');
INSERT INTO objetos_comunes (id_objeto, efecto) VALUES
                                                    (1, ''),
                                                    (2, ''),
                                                    (3, ''),
                                                    (4, ''),
                                                    (5, ''),
                                                    (6, ''),
                                                    (7, ''),
                                                    (8, ''),
                                                    (9, ''),
                                                    (10, ''),
                                                    (11, ''),
                                                    (12, ''),
                                                    (13, ''),
                                                    (15, ''),
                                                    (16, ''),
                                                    (17, ''),
                                                    (18, ''),
                                                    (19, '');


INSERT INTO packs_inciales (nombre, id_clase) VALUES
                                                  ('Pack de aventurero', NULL),
                                                  ('Pack del clérigo', 5),
                                                  ('Pack del escriba', 7);

INSERT INTO objetos_packs_iniciales (id_objeto, id_pack_inicial, cantidad) VALUES
                                                                               (1, 1, 1),
                                                                               (2, 1, 1),
                                                                               (3, 1, 1),
                                                                               (4, 1, 1),
                                                                               (5, 1, 10),
                                                                               (6, 1, 10),
                                                                               (7, 1, 1),
                                                                               (8, 1, 1),
                                                                               (1, 2, 1),
                                                                               (9, 2, 1),
                                                                               (10, 2, 10),
                                                                               (11, 2, 1),
                                                                               (12, 2, 1),
                                                                               (13, 2, 2),
                                                                               (14, 2, 1),
                                                                               (6, 2, 2),
                                                                               (7, 2, 1),
                                                                               (1, 3, 1),
                                                                               (15, 3, 1),
                                                                               (16, 3, 1),
                                                                               (17, 3, 1),
                                                                               (18, 3, 10),
                                                                               (19, 3, 1),
                                                                               (20, 3, 1);



INSERT INTO hechizos (id, nombre, descripcion, rango, tiempo_canalizacion, duracion, coste, nivel) VALUES
                                                                                                       (1, 'Alarma', 'Activas una alarma contra intrusos. Elige una puerta, ventana o área dentro del alcance que no tenga más de 20 pies cúbicos. Hasta que el conjuro termine, una alarma te alerta cuando una criatura Diminuta o mayor toca o entra en el área protegida', 30, '1 min', '8 h', 'V, S, M (una campanilla y un alambre de plata fina)', 1),
                                                                                                       (2, 'Bola fuego', 'Lanzas una bola de fuego. Todas las criaturas que se encuentren en una esfera de 20 pies de radio cuyo centro sea ese punto deben hacer una tirada de salvación de Destreza: si fallan, reciben 8d6 puntos de daño por fuego y, si tienen éxito, la mitad.', 150, '1 accion', 'Instantaneo', 'V, S, M (un bolita de guano de murciélago y azufre)', 3),
                                                                                                       (3, 'Agarre electrizante', 'Un rayo surge de tu mano para golpear a una criatura que estás intentando tocar.', 0, '1 accion', 'Instantaneo', 'V, S', 0),
                                                                                                       (4, 'Invocar demonio', 'Satanist shit', 20, '1 accion', 'Instantaneo', 'V, M', 2);

INSERT INTO hechizos_clase (id_clase, id_hechizo) VALUES
                                                      (7, 1),
                                                      (7, 2),
                                                      (7, 3);

INSERT INTO hechizos_raza (id_raza, id_hechizo) VALUES
    (3, 4);

INSERT INTO hechizos_aprendidos (id_personaje, id_hechizo) VALUES (1, 2);