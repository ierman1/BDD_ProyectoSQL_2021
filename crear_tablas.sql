CREATE TABLE personajes (
	id BIGSERIAL,
	id_clase NUMERIC NOT NULL,
	id_raza NUMERIC NOT NULL,
	
	-- datos
	nombre varchar(255) NOT NULL,
	nivel NUMERIC NOT NULL,
	esta_inspirado BOOLEAN NOT NULL DEFAULT FALSE,
	trasfondo TEXT,
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

CREATE TABLE clases (
	id BIGSERIAL,
	id_clase_padre NUMERIC,
	nombre VARCHAR(255) NOT NULL,
	descripcion TEXT,
	dado_vida NUMERIC NOT NULL,
	salvacion_1 NUMERIC NOT NULL,
	salvacion_2 NUMERIC,
	
	CONSTRAINT clases_pk PRIMARY KEY (id)
);

CREATE TABLE razas (
	id BIGSERIAL,
	nombre VARCHAR(255) NOT NULL,
	descripcion TEXT,
	velocidad_a_pie NUMERIC NOT NULL,
	velocidad_nado NUMERIC NOT NULL DEFAULT 0,
	velocidad_vuelo NUMERIC NOT NULL DEFAULT 0,
	ventajas TEXT,
	idiomas TEXT,
	altura VARCHAR(10) NOT NULL,
	
	CONSTRAINT razas_pk PRIMARY KEY (id)
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
	id_objeto NUMERIC,
	efecto TEXT,
	
	CONSTRAINT objetos_comunes_pk PRIMARY KEY (id_objeto)
);

CREATE TABLE armaduras (
	id_objeto NUMERIC,
	clase VARCHAR(255) NOT NULL,
	defensa NUMERIC NOT NULL DEFAULT 0,
	bonus TEXT,
	
	CONSTRAINT armaduras_pk PRIMARY KEY (id_objeto)
);

CREATE TABLE armas (
	id_objeto NUMERIC,
	clase varchar(255) NOT NULL,
	dano1 NUMERIC NOT NULL DEFAULT 0,
	dano2 NUMERIC,
	
	CONSTRAINT armas_pk PRIMARY KEY (id_objeto)
);

CREATE TABLE inventarios (
	id_personaje NUMERIC,
	id_objeto NUMERIC,
	cantidad NUMERIC NOT NULL DEFAULT 1,
	
	CONSTRAINT inventarios_pk PRIMARY KEY (id_personaje, id_objeto)
);

CREATE TABLE objetos_iniciales (
	id_clase NUMERIC,
	id_objeto NUMERIC,
	cantidad NUMERIC NOT NULL DEFAULT 1,
	
	CONSTRAINT objetos_iniciales_pk PRIMARY KEY (id_clase, id_objeto)
);

CREATE TABLE hechizos_aprendidos (
	id_personaje NUMERIC,
	id_hechizo NUMERIC,
	
	CONSTRAINT hechizos_aprendidos_pk PRIMARY KEY (id_personaje, id_hechizo)
);

CREATE TABLE hechizos_clase (
	id_clase NUMERIC,
	id_hechizo NUMERIC,
	
	CONSTRAINT hechizos_clase_pk PRIMARY KEY (id_clase, id_hechizo)
);

CREATE TABLE hechizos_raza (
	id_raza NUMERIC,
	id_hechizo NUMERIC,
	
	CONSTRAINT hechizos_raza_pk PRIMARY KEY (id_raza, id_hechizo)
);