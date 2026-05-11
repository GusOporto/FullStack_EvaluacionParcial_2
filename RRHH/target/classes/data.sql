--Insertar Regiones
INSERT IGNORE INTO regiones (nombre) VALUES ('Metropolitana');

--Insertar Comunas
INSERT IGNORE INTO comunas (nombre, region_id) VALUES ('Cerrillos',1);
INSERT IGNORE INTO comunas (nombre, region_id) VALUES ('Maipu',1);
INSERT IGNORE INTO comunas (nombre, region_id) VALUES ('Lo Espejo',1);

--Insertar Sucursales
INSERT IGNORE INTO sucursales (nombre, direccion, region_id, comuna_id) VALUES ('Sucursal Cerrillos','Calle Falsa 123',1,1);
INSERT IGNORE INTO sucursales (nombre, direccion, region_id, comuna_id) VALUES ('Sucursal Maipu','Calle Falsa 123',1,2);
INSERT IGNORE INTO sucursales (nombre, direccion, region_id, comuna_id) VALUES ('Sucursal Lo Espejo','Calle Falsa 123',1,3);

--Insertar Colaboradores
INSERT IGNORE INTO colaboradores (id, apellidos, correo, direccion, fecha_nacimiento, nombres, run, telefono, cargos_id, comuna_id, region_id)
VALUES (1,'Gonzalez','pedro.gonzalez@rrhh.cl','Calle Falsa 123', '2001-11-18', 'Pedro', '103484629', '56955556666', 1, 1, 1);
INSERT IGNORE INTO colaboradores (id, apellidos, correo, direccion, fecha_nacimiento, nombres, run, telefono, cargos_id, comuna_id, region_id)
VALUES (2,'Perez','juan.perez@rrhh.cl','Calle Falsa 123', '2000-05-15', 'Juan', '15083663K', '56911112222', 2, 2, 1);
INSERT IGNORE INTO colaboradores (id, apellidos, correo, direccion, fecha_nacimiento, nombres, run, telefono, cargos_id, comuna_id, region_id)
VALUES (3,'Lopez','ana.lopez@rrhh.cl','Calle Falsa 123', '1997-01-04', 'Ana', '123456789', '56933334444', 3, 3, 1);

--Insertar Asociaciones
INSERT IGNORE INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (1, 1);
INSERT IGNORE INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (2, 2);
INSERT IGNORE INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (3, 3);


-- Insertar Cargos
INSERT IGNORE INTO cargos (id, nombre, descripcion, sueldo)
VALUES (3,'Cajero', 'Se encarga de escnear productos', 525000);
INSERT IGNORE INTO cargos (id,nombre, descripcion, sueldo)
VALUES (2'Limpia pisos', 'Se encarga de la limpieza del local', 425000);
INSERT IGNORE INTO cargos (id,nombre, descripcion, sueldo)
VALUES (1,'Administrador de Tienda', 'Se encarga de administrar la tienda', 725000);

-- Insertar Curriculum
INSERT IGNORE INTO curriculum (id,nombre, edad, experiencia_laboral, certificaciones, habilidades, fortalezas, idiomas)
VALUES (1,'Benjamin Saavedra', 27, '1 años con Java', 'Certificado Java', 'Java, Git', 'Responsabilidad', 'Español, Ingles');
INSERT IGNORE INTO curriculum (id,nombre, edad, experiencia_laboral, certificaciones, habilidades, fortalezas, idiomas)
VALUES (2,'Gustavo Oporto', 22, '3 años con Java y Sql', 'Certificado Java y sql', 'Java, SQL, Git', 'Responsabilidad y aprendizaje', 'Español, Ingles y italiano');
INSERT IGNORE INTO curriculum (id,nombre, edad, experiencia_laboral, certificaciones, habilidades, fortalezas, idiomas)
VALUES (1,'Krishna ', 22, '2 años con Java ', 'Certificado Java', 'Java, SQL, Git ', 'Responsabilidad', 'Español, Ingles y frances');

-- Insertar Títulos
INSERT IGNORE INTO titulo (id,nombre, institucion, fecha_obtencion)
VALUES (3,'Ingeniero en Informatica', 'Duoc UC sede plaza oeste', '2023-02-17');
INSERT IGNORE INTO titulo (id,nombre, institucion, fecha_obtencion)
VALUES (2.'Ingeniero en Informatica', 'Duoc UC sede maipu', '2022-12-25');
INSERT IGNORE INTO titulo (id,nombre, institucion, fecha_obtencion)
VALUES (1,'Ingeniero en Informatica', 'Duoc UC sede Inglaterra', '2024-11-15');

-- Insertar Evaluaciones
INSERT IGNORE INTO evaluaciones (id,fecha_evaluacion, periodo, observaciones, fortalezas, debilidades, por_mejorar)
VALUES (1,'2022-08-32', 'Primer Semestre 2026', 'increible desempeño', 'Puntualidad', 'Comunicacion', 'Liderazgo');
INSERT IGNORE INTO evaluaciones (id,fecha_evaluacion, periodo, observaciones, fortalezas, debilidades, por_mejorar)
VALUES (2,'2024-01-11', 'Primer Semestre 2025', 'buen desempeño', 'personalidad', 'ninguna', 'Liderazgo');
INSERT IGNORE INTO evaluaciones (id,fecha_evaluacion, periodo, observaciones, fortalezas, debilidades, por_mejorar)
VALUES (3,'2026-05-10', 'Primer Semestre 2023', 'Excelente desempeño', 'Puntualidad', 'Comunicacion', 'Liderazgo');
