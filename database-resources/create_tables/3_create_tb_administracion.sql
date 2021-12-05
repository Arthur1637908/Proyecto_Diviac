CREATE TABLE administracion.tb_asignacion (
  int_id_asignacion bigserial NOT NULL,
  vch_id_division uuid NOT NULL,
  vch_id_efectivo uuid NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_asignacion)
);

CREATE TABLE administracion.tb_division (
  vch_id_division uuid NOT NULL,
  vch_cod_division varchar(50) NOT NULL,
  vch_siglas varchar(255),
  vch_nombre_division varchar(255),
  vch_desc_division varchar(255),
  int_id_direccion bigint NOT NULL,
  vch_correo varchar(255) NOT NULL,
  vch_telefono varchar(255) NOT NULL,
  vch_anexo varchar(255),
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (vch_id_division),
  CONSTRAINT UQ_vch_cod_division UNIQUE (vch_cod_division)
);

CREATE TABLE administracion.tb_division_tb_efectivo (
  int_id_division_efectivo bigserial NOT NULL,
  vch_id_division uuid NOT NULL,
  vch_id_efectivo uuid NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_division_efectivo),
  CONSTRAINT uq_division_efectivo UNIQUE (vch_id_division, vch_id_efectivo)
);

CREATE TABLE administracion.tb_documento_identidad (
  int_id_documento_identidad bigserial NOT NULL,
  vch_id_efectivo uuid NOT NULL,
  int_id_tipo_documento integer NOT NULL,
  vch_numero_documento varchar(255) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_documento_identidad)
);

CREATE TABLE administracion.tb_efectivo (
  vch_id_efectivo uuid NOT NULL,
  vch_cip varchar(255) NOT NULL,
  vch_primer_nombre varchar(255) NOT NULL,
  vch_segundo_nombre varchar(255),
  vch_apellido_paterno varchar(255) NOT NULL,
  vch_apellido_materno varchar(255) NOT NULL,
  int_id_cargo integer,
  int_id_grado integer,
  int_id_sexo integer NOT NULL,
  dtm_fecha_nacimiento date NOT NULL,
  vch_seudonimo varchar(255),
  int_id_estado_civil integer NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (vch_id_efectivo),
  CONSTRAINT uq_vch_cip UNIQUE (vch_cip)
);

CREATE TABLE administracion.tb_situacion (
  int_id_situacion bigserial NOT NULL,
  vch_id_efectivo uuid NOT NULL,
  int_id_tipo_situacion integer NOT NULL,
  vch_id_division uuid,
  dtm_fecha_inicio date NOT NULL,
  dtm_fecha_termino date,
  vch_nombre_sustento varchar(500) NOT NULL,
  vch_ruta_sustento varchar(500) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_situacion)
);

CREATE TABLE generales.tb_departamento (
  int_id_pais integer NOT NULL,
  int_id_departamento integer NOT NULL,
  vch_nombre_departamento varchar(255),
  PRIMARY KEY (int_id_departamento)
);

CREATE TABLE generales.tb_direccion (
  int_id_direccion bigserial NOT NULL,
  int_id_distrito integer NOT NULL,
  int_id_tipo_direccion integer NOT NULL,
  vch_desc_direccion varchar(255),
  vch_numero varchar(255),
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_direccion)
);

CREATE TABLE generales.tb_distrito (
  int_id_provincia integer NOT NULL,
  int_id_distrito integer NOT NULL,
  vch_nombre_distrito varchar(255),
  PRIMARY KEY (int_id_distrito)
);

CREATE TABLE generales.tb_grupo_parametro (
  int_id_grupo integer NOT NULL,
  vch_cod_grupo varchar(250),
  vch_desc_grupo varchar(255),
  bol_estado boolean,
  PRIMARY KEY (int_id_grupo)
);

CREATE TABLE generales.tb_pais (
  int_id_pais integer NOT NULL,
  vch_nombre_pais varchar(255),
  PRIMARY KEY (int_id_pais)
);

CREATE TABLE generales.tb_parametro (
  int_id_parametro integer NOT NULL,
  int_id_grupo integer NOT NULL,
  vch_desc_parametro varchar(255),
  bol_estado boolean,
  PRIMARY KEY (int_id_parametro)
);

CREATE TABLE generales.tb_provincia (
  int_id_departamento integer NOT NULL,
  int_id_provincia integer NOT NULL,
  vch_nombre_provincia varchar(255),
  PRIMARY KEY (int_id_provincia)
);

ALTER TABLE administracion.tb_asignacion ADD CONSTRAINT fk_tb_asignacion_tb_division_1 FOREIGN KEY (vch_id_division) REFERENCES administracion.tb_division (vch_id_division);
ALTER TABLE administracion.tb_asignacion ADD CONSTRAINT fk_tb_asignacion_tb_efectivo_1 FOREIGN KEY (vch_id_efectivo) REFERENCES administracion.tb_efectivo (vch_id_efectivo);
ALTER TABLE administracion.tb_division ADD CONSTRAINT fk_Division_Direccion_1 FOREIGN KEY (int_id_direccion) REFERENCES generales.tb_direccion (int_id_direccion);
ALTER TABLE administracion.tb_division_tb_efectivo ADD CONSTRAINT fk_TB_Division_TB_Efectivo_TB_Division_1 FOREIGN KEY (vch_id_division) REFERENCES administracion.tb_division (vch_id_division);
ALTER TABLE administracion.tb_division_tb_efectivo ADD CONSTRAINT fk_TB_Division_TB_Efectivo_TB_Efectivo_1 FOREIGN KEY (vch_id_efectivo) REFERENCES administracion.tb_efectivo (vch_id_efectivo);
ALTER TABLE administracion.tb_documento_identidad ADD CONSTRAINT fk_tb_documento_identidad_tb_efectivo_1 FOREIGN KEY (vch_id_efectivo) REFERENCES administracion.tb_efectivo (vch_id_efectivo);
ALTER TABLE administracion.tb_situacion ADD CONSTRAINT fk_tb_situacion_tb_division_1 FOREIGN KEY (vch_id_division) REFERENCES administracion.tb_division (vch_id_division);
ALTER TABLE administracion.tb_situacion ADD CONSTRAINT fk_tb_situacion_tb_efectivo_1 FOREIGN KEY (vch_id_efectivo) REFERENCES administracion.tb_efectivo (vch_id_efectivo);
ALTER TABLE generales.tb_departamento ADD CONSTRAINT fk_TB_Departamento_TB_Pais_1 FOREIGN KEY (int_id_pais) REFERENCES generales.tb_pais (int_id_pais);
ALTER TABLE generales.tb_direccion ADD CONSTRAINT fk_Direccion_Distrito_1 FOREIGN KEY (int_id_distrito) REFERENCES generales.tb_distrito (int_id_distrito);
ALTER TABLE generales.tb_distrito ADD CONSTRAINT fk_tb_distrito_tb_provincia FOREIGN KEY (int_id_provincia) REFERENCES generales.tb_provincia (int_id_provincia);
ALTER TABLE generales.tb_parametro ADD CONSTRAINT fk_TB_Parametro_TB_Grupo_Parametro_1 FOREIGN KEY (int_id_grupo) REFERENCES generales.tb_grupo_parametro (int_id_grupo);
ALTER TABLE generales.tb_provincia ADD CONSTRAINT fk_TB_Provincia_TB_Departamento_1 FOREIGN KEY (int_id_departamento) REFERENCES generales.tb_departamento (int_id_departamento);

