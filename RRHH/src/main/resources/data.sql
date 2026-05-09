--Insertar Regiones
INSERT INTO regiones (nombre) VALUES ('Metropolitana');

--Insertar Comunas
INSERT INTO comunas (nombre, region_id) VALUES ('Cerrillos',1);
INSERT INTO comunas (nombre, region_id) VALUES ('Maipu',1);
INSERT INTO comunas (nombre, region_id) VALUES ('Lo Espejo',1);

--Insertar Sucursales
INSERT INTO sucursales (nombre, direccion, region_id, comuna_id) VALUES ('Sucursal Cerrillos','Calle Falsa 123',1,1);
INSERT INTO sucursales (nombre, direccion, region_id, comuna_id) VALUES ('Sucursal Maipu','Calle Falsa 123',1,2);
INSERT INTO sucursales (nombre, direccion, region_id, comuna_id) VALUES ('Sucursal Lo Espejo','Calle Falsa 123',1,3);

--Insertar Colaboradores
INSERT INTO colaboradores (run, nombres, apellidos, fecha_nacimiento, telefono, correo, direccion, region_id, comuna_id, sucursal_id)
VALUES ('15083663K', 'Juan', 'Perez', '2000-05-15', '56911112222', 'juan.perez@rrhh.cl', 'Calle Falsa 123', 1, 1, 1);
INSERT INTO colaboradores (run, nombres, apellidos, fecha_nacimiento, telefono, correo, direccion, region_id, comuna_id, sucursal_id)
VALUES ('123456789', 'Ana', 'Lopez', '1997-01-04', '56933334444', 'ana.lopez@rrhh.cl', 'Calle Falsa 123', 1, 2, 2);
INSERT INTO colaboradores (run, nombres, apellidos, fecha_nacimiento, telefono, correo, direccion, region_id, comuna_id, sucursal_id)
VALUES ('103484629', 'Pedro', 'Gonzalez', '2001-11-18', '56955556666', 'pedro.gonzalez@rrhh.cl', 'Calle Falsa 123', 1, 3, 3);

--Asociaciones
INSERT INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (1, 1);
INSERT INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (2, 2);
INSERT INTO colaborador_sucursal (colaborador_id, sucursal_id) VALUES (3, 3);

