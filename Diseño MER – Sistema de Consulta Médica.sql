CREATE TABLE "paciente" (
	"id_paciente" SERIAL NOT NULL UNIQUE,
	"nombre" VARCHAR(100) NOT NULL,
	"documento_identidad" VARCHAR(20) NOT NULL UNIQUE,
	"fecha_nacimiento" DATE NOT NULL,
	"telefono" VARCHAR(20),
	"correo_electronico" VARCHAR(100),
	"direccion" VARCHAR(200),
	PRIMARY KEY("id_paciente")
);

CREATE TABLE "medico" (
	"id_medico" SERIAL NOT NULL UNIQUE,
	"nombre" VARCHAR(100) NOT NULL,
	"apellido" VARCHAR(100) NOT NULL,
	"especialidad" VARCHAR(100) NOT NULL,
	"numero_licencia" VARCHAR(50) NOT NULL UNIQUE,
	"telefono" VARCHAR(20),
	"correo_electronico" VARCHAR(100),
	PRIMARY KEY("id_medico")
);

CREATE TABLE "consulta" (
	"id_consulta" SERIAL NOT NULL UNIQUE,
	"fecha" DATE NOT NULL,
	"hora" TIME NOT NULL,
	"hora_fin" TIME NOT NULL,
	"diagnostico" TEXT,
	"id_paciente" INTEGER,
	"id_medico" INTEGER,
	"motivo_consulta" TEXT,
	PRIMARY KEY("id_consulta")
);

CREATE TABLE "receta" (
	"id_receta" SERIAL NOT NULL UNIQUE,
	"medicamento" VARCHAR(100) NOT NULL,
	"dosis" VARCHAR(50),
	"instrucciones" TEXT,
	"id_consulta" INTEGER,
	PRIMARY KEY("id_receta")
);

CREATE TABLE "usuario" (
	"id_usuario" SERIAL NOT NULL UNIQUE,
	"username" VARCHAR(50) NOT NULL UNIQUE,
	"password" VARCHAR(100) NOT NULL,
	"rol" VARCHAR(20) NOT NULL,
	PRIMARY KEY("id_usuario")
);

ALTER TABLE "consulta"
ADD FOREIGN KEY("id_paciente") REFERENCES "paciente"("id_paciente")
ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE "consulta"
ADD FOREIGN KEY("id_medico") REFERENCES "medico"("id_medico")
ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE "receta"
ADD FOREIGN KEY("id_consulta") REFERENCES "consulta"("id_consulta")
ON UPDATE NO ACTION ON DELETE NO ACTION;