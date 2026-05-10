-- Insertar Cargos
INSERT IGNORE INTO cargos (nombre, descripcion, sueldo) 
VALUES ('Cajero', 'Se encarga de escnear productos', 525000);
INSERT IGNORE INTO cargos (nombre, descripcion, sueldo) 
VALUES ('Limpia pisos', 'Se encarga de la limpieza del local', 425000);
INSERT IGNORE INTO cargos (nombre, descripcion, sueldo) 
VALUES ('Administrador de Tienda', 'Se encarga de administrar la tienda', 725000);

-- Insertar Curriculum
INSERT IGNORE INTO curriculum (nombre, edad, experiencia_laboral, certificaciones, habilidades, fortalezas, idiomas) 
VALUES ('Benjamin Saavedra', 27, '1 años con Java', 'Certificado Java', 'Java, Git', 'Responsabilidad', 'Español, Ingles');
INSERT IGNORE INTO curriculum (nombre, edad, experiencia_laboral, certificaciones, habilidades, fortalezas, idiomas) 
VALUES ('Gustavo Oporto', 22, '3 años con Java y Sql', 'Certificado Java y sql', 'Java, SQL, Git', 'Responsabilidad y aprendizaje', 'Español, Ingles y italiano');
INSERT IGNORE INTO curriculum (nombre, edad, experiencia_laboral, certificaciones, habilidades, fortalezas, idiomas) 
VALUES ('Krishna ', 22, '2 años con Java ', 'Certificado Java', 'Java, SQL, Git ', 'Responsabilidad', 'Español, Ingles y frances');

-- Insertar Títulos
INSERT IGNORE INTO titulo (nombre, institucion, fecha_obtencion) 
VALUES ('Ingeniero en Informatica', 'Duoc UC sede plaza oeste', '2023-02-17');
INSERT IGNORE INTO titulo (nombre, institucion, fecha_obtencion) 
VALUES ('Ingeniero en Informatica', 'Duoc UC sede maipu', '2022-12-25');
INSERT IGNORE INTO titulo (nombre, institucion, fecha_obtencion) 
VALUES ('Ingeniero en Informatica', 'Duoc UC sede Inglaterra', '2024-11-15');

-- Insertar Evaluaciones (Ojo con el nombre de la tabla si tiene el error 'evlauaciones')
INSERT IGNORE INTO evlauaciones (fecha_evaluacion, periodo, observaciones, fortalezas, debilidades, por_mejorar) 
VALUES ('2022-08-32', 'Primer Semestre 2026', 'increible desempeño', 'Puntualidad', 'Comunicacion', 'Liderazgo');
INSERT IGNORE INTO evlauaciones (fecha_evaluacion, periodo, observaciones, fortalezas, debilidades, por_mejorar) 
VALUES ('2024-01-11', 'Primer Semestre 2025', 'buen desempeño', 'personalidad', 'ninguna', 'Liderazgo');
INSERT IGNORE INTO evlauaciones (fecha_evaluacion, periodo, observaciones, fortalezas, debilidades, por_mejorar) 
VALUES ('2026-05-10', 'Primer Semestre 2023', 'Excelente desempeño', 'Puntualidad', 'Comunicacion', 'Liderazgo');
