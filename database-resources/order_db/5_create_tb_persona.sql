CREATE TABLE generales.tb_arma (
  int_id_arma bigserial NOT NULL,
  int_tipo_arma integer NOT NULL,
  vch_marca varchar(255),
  vch_serie varchar(255),
  vch_calibre varchar(255),
  vch_especificar varchar(255),
  vch_observacion text,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_arma)
);

CREATE TABLE generales.tb_empresa (
  int_id_empresa bigserial NOT NULL,
  vch_ruc varchar(255) NOT NULL,
  vch_nombre_empresa varchar(255),
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion time NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_empresa),
  CONSTRAINT uq_empresa_nombre UNIQUE (vch_nombre_empresa)
);

CREATE TABLE generales.tb_entidad_estado (
  int_id_entidad_estado bigserial NOT NULL,
  vch_nombre_entidad_estado varchar(255),
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion time NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_entidad_estado),
  CONSTRAINT uq_entidad_estado_nombre UNIQUE (vch_nombre_entidad_estado)
);

CREATE TABLE generales.tb_multimedia (
  int_id_multimedia bigserial NOT NULL,
  int_tipo_archivo smallint NOT NULL,
  vch_titulo varchar(255) NOT NULL,
  vch_ruta varchar(255) NOT NULL,
  vch_nombre_archivo varchar(255) NOT NULL,
  vch_extension varchar(255) NOT NULL,
  txt_descripcion text,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion time NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_multimedia)
);

CREATE TABLE generales.tb_vehiculo (
  int_id_vehiculo bigserial NOT NULL,
  int_tipo_vehiculo smallint,
  vch_clase_vehiculo varchar(255),
  vch_marca_vehiculo varchar(255),
  vch_modelo_vehiculo varchar(255),
  vch_placa_vehiculo varchar(255) NOT NULL,
  vch_vin_vehiculo varchar(255),
  vch_serie_vehiculo varchar(255),
  vch_motor_vehiculo varchar(255),
  vch_otros_vehiculo varchar(255),
  vch_observacion varchar(1000),
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_vehiculo),
  CONSTRAINT uq_vehiculo_placa UNIQUE (vch_placa_vehiculo)
);

CREATE TABLE investigacion_criminal.tb_caracteristica_fisica (
  int_id_caracteristica_fisica bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_tipo_caracteristica smallint NOT NULL,
  vch_desc_caracteristica varchar(255) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_caracteristica_fisica)
);

CREATE TABLE investigacion_criminal.tb_dato_laboral (
  int_id_dato_laboral bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_id_empresa bigint NOT NULL,
  vch_nombre_cargo varchar(255),
  dtm_fecha_ingreso date,
  dtm_fecha_salida date,
  int_id_direccion bigint NOT NULL,
  bol_trabajo_actual boolean,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion time NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_dato_laboral)
);

CREATE TABLE investigacion_criminal.tb_direccion_personal (
  int_id_direccion_personal bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_id_direccion bigint NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_direccion_personal)
);

CREATE TABLE investigacion_criminal.tb_doc_identidad_per (
  int_id_doc_identidad bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_tipo_doc integer NOT NULL,
  vch_numero_doc varchar(255) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion time NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_doc_identidad)
);

CREATE TABLE investigacion_criminal.tb_doc_personal (
  int_id_informacion_basica bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_id_multimedia bigint NOT NULL,
  int_tipo_categoria integer NOT NULL,
  int_sub_tipo_categoria integer,
  int_id_entidad_estado bigint,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_informacion_basica)
);

CREATE TABLE investigacion_criminal.tb_email_personal (
  int_id_email_personal bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  vch_email varchar(100) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_email_personal),
  CONSTRAINT uq_persona_email UNIQUE (vch_id_persona, vch_email)
);

CREATE TABLE investigacion_criminal.tb_persona (
  vch_id_persona uuid NOT NULL,
  int_tipo_persona integer NOT NULL,
  int_tipo_documento integer NOT NULL,
  vch_numero_documento varchar(255) NOT NULL,
  vch_primer_nombre varchar(255),
  vch_segundo_nombre varchar(255),
  vch_apellido_paterno varchar(255),
  vch_apellido_materno varchar(255),
  dtm_fecha_nacimiento date,
  int_sexo integer DEFAULT NULL,
  int_tipo_situacion integer,
  vch_especificar varchar(255),
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (vch_id_persona)
);

CREATE TABLE investigacion_criminal.tb_persona_arma (
  int_id_pers_arma bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_id_arma bigint NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_pers_arma)
);

CREATE TABLE investigacion_criminal.tb_persona_vehiculo (
  int_id_pers_vehi bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_id_vehiculo bigint NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_pers_vehi)
);

CREATE TABLE investigacion_criminal.tb_red_social (
  int_id_red_social bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  int_tipo_red_social integer NOT NULL,
  vch_enlace varchar(255) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_red_social)
);

CREATE TABLE investigacion_criminal.tb_telefono_laboral (
  int_id_telefono_laboral bigserial NOT NULL,
  int_id_dato_laboral bigint NOT NULL,
  vch_telefono varchar(9) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion time NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_telefono_laboral),
  CONSTRAINT uq_dato_laboral_telefono UNIQUE (vch_telefono)
);

CREATE TABLE investigacion_criminal.tb_telefono_personal (
  int_id_telefono_personal bigserial NOT NULL,
  vch_id_persona uuid NOT NULL,
  vch_telefono varchar(9) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_telefono_personal),
  CONSTRAINT uq_persona_telefono UNIQUE (vch_id_persona, vch_telefono)
);

ALTER TABLE investigacion_criminal.tb_caracteristica_fisica ADD CONSTRAINT fk_TB_Persona_Caracteristica_Fisica_TB_Persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_dato_laboral ADD CONSTRAINT fk_TB_Datos_Laborales_TB_Direccion_1 FOREIGN KEY (int_id_direccion) REFERENCES generales.tb_direccion (int_id_direccion);
ALTER TABLE investigacion_criminal.tb_dato_laboral ADD CONSTRAINT fk_TB_Datos_Laborales_TB_Empresa_1 FOREIGN KEY (int_id_empresa) REFERENCES generales.tb_empresa (int_id_empresa);
ALTER TABLE investigacion_criminal.tb_dato_laboral ADD CONSTRAINT fk_TB_Dato_Laboral_TB_Persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_direccion_personal ADD CONSTRAINT fk_TB_Persona_TB_Direccion_TB_Direccion_1 FOREIGN KEY (int_id_direccion) REFERENCES generales.tb_direccion (int_id_direccion);
ALTER TABLE investigacion_criminal.tb_direccion_personal ADD CONSTRAINT fk_TB_Persona_TB_Direccion_TB_Persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_doc_identidad_per ADD CONSTRAINT fk_tb_documento_identidad_tb_persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_doc_personal ADD CONSTRAINT fk_TB_Persona_Informacion_Basica_TB_Multimedia_1 FOREIGN KEY (int_id_multimedia) REFERENCES generales.tb_multimedia (int_id_multimedia);
ALTER TABLE investigacion_criminal.tb_doc_personal ADD CONSTRAINT fk_TB_Persona_Informacion_Basica_TB_Entidad_Estado_1 FOREIGN KEY (int_id_entidad_estado) REFERENCES generales.tb_entidad_estado (int_id_entidad_estado);
ALTER TABLE investigacion_criminal.tb_doc_personal ADD CONSTRAINT fk_TB_Informacion_Basica_TB_Persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_email_personal ADD CONSTRAINT fk_TB_Persona_TB_Email_TB_Persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_persona_arma ADD CONSTRAINT fk_tb_persona_arma_tb_arma_1 FOREIGN KEY (int_id_arma) REFERENCES generales.tb_arma (int_id_arma);
ALTER TABLE investigacion_criminal.tb_persona_arma ADD CONSTRAINT fk_tb_persona_arma_tb_persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_persona_vehiculo ADD CONSTRAINT fk_tb_persona_vehiculo_tb_persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_persona_vehiculo ADD CONSTRAINT fk_tb_persona_vehiculo_tb_vehiculo_1 FOREIGN KEY (int_id_vehiculo) REFERENCES generales.tb_vehiculo (int_id_vehiculo);
ALTER TABLE investigacion_criminal.tb_red_social ADD CONSTRAINT fk_tb_red_social_tb_persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);
ALTER TABLE investigacion_criminal.tb_telefono_laboral ADD CONSTRAINT fk_TB_Dato_Laboral_Telefono_TB_Dato_Laboral_1 FOREIGN KEY (int_id_dato_laboral) REFERENCES investigacion_criminal.tb_dato_laboral (int_id_dato_laboral);
ALTER TABLE investigacion_criminal.tb_telefono_personal ADD CONSTRAINT fk_TB_Persona_TB_Telefono_TB_Persona_1 FOREIGN KEY (vch_id_persona) REFERENCES investigacion_criminal.tb_persona (vch_id_persona);

