INSERT INTO generales.tb_direccion(
	int_id_direccion, int_id_distrito, int_id_tipo_direccion, vch_desc_direccion, vch_numero, bol_estado, vch_usuario_creacion, dtm_fecha_creacion, int_rol_usuario_creacion, vch_usuario_modificacion, dtm_fecha_modificacion, int_rol_usuario_modificacion)
	VALUES (1, 1, 1, 'direccion ejemplo', '123', TRUE, '123456', '05/02/2021', 1, '123456', '05/02/2021', 1);
	
INSERT INTO administracion.tb_division(
	vch_id_division, vch_cod_division, vch_siglas, vch_nombre_division, vch_desc_division, int_id_direccion, vch_correo, vch_telefono, vch_anexo, bol_estado, vch_usuario_creacion, dtm_fecha_creacion, int_rol_usuario_creacion, vch_usuario_modificacion, dtm_fecha_modificacion, int_rol_usuario_modificacion)
	VALUES ('6ecd8c99-4036-403d-bf84-cf8400f67836', 'DIV001', 'D100', 'DIVISION TEST', 'THIS IS A TEST', 1, 'DIVISION_TEST@PNP.GOB.PE', '987654321', '123', TRUE, '123456', '05/02/2021', 1, '123456', '05/02/2021', 1);
	
INSERT INTO administracion.tb_division(
	vch_id_division, vch_cod_division, vch_siglas, vch_nombre_division, vch_desc_division, int_id_direccion, vch_correo, vch_telefono, vch_anexo, bol_estado, vch_usuario_creacion, dtm_fecha_creacion, int_rol_usuario_creacion, vch_usuario_modificacion, dtm_fecha_modificacion, int_rol_usuario_modificacion)
	VALUES ('c81d4e2e-bcf2-11e6-869b-7df92533d2db', 'DIV002', 'D200', 'DIVISION TEST', 'THIS IS A TEST', 1, 'DIVISION_TEST2@PNP.GOB.PE', '987654321', '123', TRUE, '123456', '05/02/2021', 1, '123456', '05/02/2021', 1);
	
INSERT INTO administracion.tb_division(
	vch_id_division, vch_cod_division, vch_siglas, vch_nombre_division, vch_desc_division, int_id_direccion, vch_correo, vch_telefono, vch_anexo, bol_estado, vch_usuario_creacion, dtm_fecha_creacion, int_rol_usuario_creacion, vch_usuario_modificacion, dtm_fecha_modificacion, int_rol_usuario_modificacion)
	VALUES ('237e9877-e79b-12d4-a765-321741963000', 'DIV003', 'D300', 'DIVISION TEST', 'THIS IS A TEST', 1, 'DIVISION_TEST3@PNP.GOB.PE', '987654321', '123', TRUE, '123456', '05/02/2021', 1, '123456', '05/02/2021', 1);
	
	