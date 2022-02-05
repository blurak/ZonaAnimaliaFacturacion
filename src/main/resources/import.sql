INSERT INTO  regiones (nombre) VALUES ('CHINA');
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 1kg',3000,10,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 2kg',5000,10,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 10kg',6000,20,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 15kg',7000,30,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 30kg',8000,50,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 1kg',3000,10,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 2kg',5000,10,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 10kg',6000,20,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 15kg',7000,30,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 30kg',8000,50,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 1kg',3000,10,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 2kg',5000,10,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 10kg',6000,20,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 15kg',7000,30,NOW());
INSERT INTO  productos (nombre,precio,cantidad,create_at) VALUES ('Doncant 30kg',8000,50,NOW());

INSERT INTO  clientes (nombre,direccion,telefono,foto,creat_at) VALUES ('maicol','calle9#estrellita','311450231',null,NOW());
INSERT INTO  clientes (nombre,direccion,telefono,foto,creat_at) VALUES ('maicol2','calle9#estrellita2','3114502312',null,NOW());

INSERT INTO  facturas (descripcion,observacion,cliente_id,create_at) VALUES ('Factura Equipos De oficina','Si Tiene',1,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,1,1);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(1,1,2);
INSERT INTO  facturas (descripcion,observacion,cliente_id,create_at) VALUES ('Factura Equipos De Computo',null,1,NOW());
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(2,2,4);
INSERT INTO facturas_items(cantidad,factura_id,producto_id) VALUES(3,2,3);
INSERT INTO  usuarios (apellido,nombre,email,enable,password,username) VALUES ('lopez','yuli','icamilo@gmail.com',1,'$2a$10$ZsU9qA6sOpjZK7aoriFiUuEg02yigVR/c01lwTj.P3Pi08gargL3a','admin');
INSERT INTO  usuarios (apellido,nombre,email,enable,password,username) VALUES ('lopez','yuli','icamilo@gamail.com',1,'$2a$10$ZsU9qA6sOpjZK7aoriFiUuEg02yigVR/c01lwTj.P3Pi08gargL3a','user');

INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES('ROLE_USER');

INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES(1,1);
INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES(1,2);
INSERT INTO usuarios_roles(usuario_id,rol_id) VALUES(2,2);