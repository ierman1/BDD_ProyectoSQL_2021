CREATE TABLE clases (
                        id bigserial,
                        nombre VARCHAR(255) NOT NULL,
                        descripcion TEXT,
                        dado_vida NUMERIC NOT NULL,
                        salvacion_1 NUMERIC NOT NULL,
                        salvacion_2 NUMERIC,

                        CONSTRAINT clases_pk PRIMARY KEY (id)
);

CREATE TABLE razas (
                       id BIGSERIAL,
                       id_raza_padre BIGINT REFERENCES razas (id),
                       nombre VARCHAR(255) NOT NULL,
                       descripcion TEXT,
                       velocidad_a_pie NUMERIC NOT NULL,
                       velocidad_nado NUMERIC NOT NULL DEFAULT 0,
                       velocidad_vuelo NUMERIC NOT NULL DEFAULT 0,
                       ventajas TEXT,
                       idiomas TEXT,
                       altura TEXT NOT NULL,

                       CONSTRAINT razas_pk PRIMARY KEY (id)
);

CREATE TABLE personajes (
                            id BIGSERIAL,
                            id_clase BIGSERIAL NOT NULL REFERENCES clases (id),
                            id_raza BIGSERIAL NOT NULL REFERENCES razas(id),

    -- datos
                            nombre varchar(255) NOT NULL,
                            nivel NUMERIC NOT NULL,
                            esta_inspirado BOOLEAN NOT NULL DEFAULT FALSE,
                            trasfondo TEXT,
                            edad NUMERIC NOT NULL DEFAULT 0,
                            altura NUMERIC NOT NULL DEFAULT 0,
                            peso NUMERIC NOT NULL DEFAULT 0,
                            vida_max NUMERIC NOT NULL,
                            vida_actual NUMERIC NOT NULL,
                            oro NUMERIC NOT NULL DEFAULT 0,

    -- stats
                            fuerza NUMERIC NOT NULL,
                            destreza NUMERIC NOT NULL,
                            constitucion NUMERIC NOT NULL,
                            inteligencia NUMERIC NOT NULL,
                            sabiduria NUMERIC NOT NULL,
                            carisma NUMERIC NOT NULL,

                            CONSTRAINT personajes_pk PRIMARY KEY (id)
);



CREATE TABLE hechizos (
                          id BIGSERIAL,
                          nombre VARCHAR(255) NOT NULL,
                          descripcion TEXT,
                          rango NUMERIC,
                          tiempo_canalizacion VARCHAR(255),
                          duracion VARCHAR(255),
                          coste VARCHAR(255),
                          nivel NUMERIC NOT NULL DEFAULT 0,

                          CONSTRAINT hechizos_pk PRIMARY KEY (id)
);

CREATE TABLE objetos (
                         id BIGSERIAL,
                         nombre VARCHAR(255) NOT NULL,
                         descripcion TEXT,
                         peso NUMERIC,
                         volumen VARCHAR(255),
                         valor NUMERIC,
                         equipable BOOLEAN NOT NULL DEFAULT FALSE,

                         CONSTRAINT objetos_pk PRIMARY KEY (id)
);

CREATE TABLE objetos_comunes (
                                 id_objeto BIGSERIAL REFERENCES objetos(id),
                                 efecto TEXT,

                                 CONSTRAINT objetos_comunes_pk PRIMARY KEY (id_objeto)
);

CREATE TABLE armaduras (
                           id_objeto BIGSERIAL REFERENCES objetos(id),
                           clase VARCHAR(255) NOT NULL,
                           defensa NUMERIC NOT NULL DEFAULT 0,
                           bonus TEXT,

                           CONSTRAINT armaduras_pk PRIMARY KEY (id_objeto)
);

CREATE TABLE armas (
                       id_objeto BIGSERIAL REFERENCES objetos(id),
                       clase varchar(255) NOT NULL,
                       dano1 NUMERIC NOT NULL DEFAULT 0,
                       dano2 NUMERIC,

                       CONSTRAINT armas_pk PRIMARY KEY (id_objeto)
);

CREATE TABLE inventarios (
                             id_personaje BIGSERIAL REFERENCES personajes(id),
                             id_objeto BIGSERIAL REFERENCES objetos(id),
                             cantidad NUMERIC NOT NULL DEFAULT 1,

                             CONSTRAINT inventarios_pk PRIMARY KEY (id_personaje, id_objeto)
);

CREATE TABLE packs_inciales (
                                id BIGSERIAL,
                                nombre varchar(255) NOT NULL,
                                id_clase BIGINT REFERENCES clases(id),

                                CONSTRAINT packs_inciales_pk PRIMARY KEY (id)
);

CREATE TABLE objetos_packs_iniciales (
                                         id_objeto BIGSERIAL,
                                         id_pack_inicial BIGSERIAL REFERENCES packs_inciales(id),
                                         cantidad NUMERIC NOT NULL DEFAULT 1,

                                         CONSTRAINT objetos_packs_iniciales_pk PRIMARY KEY (id_objeto, id_pack_inicial)
);

CREATE TABLE hechizos_aprendidos (
                                     id_personaje BIGSERIAL REFERENCES personajes(id),
                                     id_hechizo BIGSERIAL REFERENCES hechizos(id),

                                     CONSTRAINT hechizos_aprendidos_pk PRIMARY KEY (id_personaje, id_hechizo)
);

CREATE TABLE hechizos_clase (
                                id_clase BIGSERIAL REFERENCES clases(id),
                                id_hechizo BIGSERIAL REFERENCES hechizos(id),

                                CONSTRAINT hechizos_clase_pk PRIMARY KEY (id_clase, id_hechizo)
);

CREATE TABLE hechizos_raza (
                               id_raza BIGSERIAL references razas(id),
                               id_hechizo BIGSERIAL REFERENCES hechizos(id),

                               CONSTRAINT hechizos_raza_pk PRIMARY KEY (id_raza, id_hechizo)
);