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
INSERT IGNORE INTO colaboradores (id, apellidos, correo, direccion, fecha_nacimiento, nombres, run, telefono, comuna_id, region_id)
VALUES (1,'Gonzalez','pedro.gonzalez@rrhh.cl','Calle Falsa 123', '2001-11-18', 'Pedro', '103484629', '56955556666', 1, 1);
INSERT IGNORE INTO colaboradores (id, apellidos, correo, direccion, fecha_nacimiento, nombres, run, telefono, comuna_id, region_id)
VALUES (2,'Perez','juan.perez@rrhh.cl','Calle Falsa 123', '2000-05-15', 'Juan', '15083663K', '56911112222', 2, 1);
INSERT IGNORE INTO colaboradores (id, apellidos, correo, direccion, fecha_nacimiento, nombres, run, telefono, comuna_id, region_id)
VALUES (3,'Lopez','ana.lopez@rrhh.cl','Calle Falsa 123', '1997-01-04', 'Ana', '123456789', '56933334444', 3, 1);

--Insertar Asociaciones
INSERT IGNORE INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (1, 1);
INSERT IGNORE INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (2, 2);
INSERT IGNORE INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (3, 3);

