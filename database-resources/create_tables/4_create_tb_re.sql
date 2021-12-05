CREATE TABLE administracion.tb_re_division (
  int_id_re_division bigserial NOT NULL,
  vch_id_division uuid NOT NULL,
  vch_identificador varchar(255) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion time NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_re_division)
);

CREATE TABLE administracion.tb_re_efectivo (
  int_id_re_efectivo bigserial NOT NULL,
  vch_id_efectivo uuid NOT NULL,
  vch_identificador varchar(255) NOT NULL,
  bol_estado boolean NOT NULL,
  vch_usuario_creacion varchar(255) NOT NULL,
  dtm_fecha_creacion timestamp NOT NULL,
  int_rol_usuario_creacion integer NOT NULL,
  vch_usuario_modificacion varchar(255),
  dtm_fecha_modificacion timestamp,
  int_rol_usuario_modificacion integer,
  PRIMARY KEY (int_id_re_efectivo)
);

ALTER TABLE administracion.tb_re_division ADD CONSTRAINT fk_tb_re_division_tb_division_1 FOREIGN KEY (vch_id_division) REFERENCES administracion.tb_division (vch_id_division);
ALTER TABLE administracion.tb_re_efectivo ADD CONSTRAINT fk_tb_re_efectivo_tb_efectivo_1 FOREIGN KEY (vch_id_efectivo) REFERENCES administracion.tb_efectivo (vch_id_efectivo);

