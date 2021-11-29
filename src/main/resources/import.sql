INSERT INTO regiones (nombre) VALUES('Sudamérica');
INSERT INTO regiones (nombre) VALUES('Centroamérica');
INSERT INTO regiones (nombre) VALUES('Norteamérica');
INSERT INTO regiones (nombre) VALUES('Europa');
INSERT INTO regiones (nombre) VALUES('Asia');
INSERT INTO regiones (nombre) VALUES('África');
INSERT INTO regiones (nombre) VALUES('Oceanía');
INSERT INTO regiones (nombre) VALUES('Antártida');

INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(1,'Jose','Perez','jp@hotmail.com',65433223,'2021-10-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(2,'Carlos','Lopez','cl@hotmail.com',65433223,'2021-01-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(3,'Maria','Orillana','mo@hotmail.com',65433223,'2021-02-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(4,'Dina','Ramirez','dr@hotmail.com',65433223,'2021-03-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(5,'Mirna','Ramos','mr@hotmail.com',65433223,'2021-04-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(6,'Pepe','Mojica','pm@hotmail.com',65433223,'2021-05-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(7,'Juan','Chavez','jc@hotmail.com',65433223,'2021-06-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(8,'Enrique','Iglesias','ei@hotmail.com',65433223,'2021-07-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(1,'Pedro','Diaz','pd@hotmail.com',65433223,'2021-08-01');
INSERT INTO clientes (region_id,nombre,apellido,email,telefono,create_at) VALUES(2,'Ramon','Gonzalez','rgonzalez@gmail.com',65433223,'2021-09-01');

INSERT INTO usuarios (username,password,enabled) VALUES('Jose','$2a$10$qEfv0B3z/eYaHk3eD1MevObsO0ymQuoeusf672UmfhDZSeYYCpbbS',1);
INSERT INTO usuarios (username,password,enabled) VALUES('Admin','$2a$10$8AYNsmRsBx.Twng/fgjk.e8H4CjZQcvqfVaA6zUMnoNqmdofK.zVq',1);

INSERT INTO roles (nombre) VALUES('ROLE_USER');
INSERT INTO roles (nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES(1,1);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES(2,2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES(2,1);