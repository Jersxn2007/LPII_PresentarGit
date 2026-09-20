create database bd_almacen;
use bd_almacen;

create table tb_categorias(
idcategoria int auto_increment  primary key,
descripcion varchar(100)
);

create table tb_proveedor(
idproveedor int auto_increment  primary key,
nombre_rs varchar(100),
telefono varchar(100),
email varchar(100)
);

create table tb_productos(
idprod int auto_increment primary key,
des_prod varchar(100),
stk_prod int,
pre_prod double,
idcategoria int,
idproveedor int,
est_prod int,
foreign key (idcategoria) references tb_categorias (idcategoria),
foreign key (idproveedor) references tb_proveedor (idproveedor)
);

insert into tb_categorias (descripcion) values 
('Pastillas'),('Jarabes'),('Jeringas');

insert into tb_proveedor (nombre_rs,telefono,email) values 
('Pharmalab','245-2100','ventas@pharmalab.com'),
('Pharmalab2','225-2100','ventas@pharmalab2.com'),
('Pharmalab3','235-2100','ventas@pharmalab3.com');

insert into tb_productos (des_prod,stk_prod,pre_prod,idcategoria,idproveedor,est_prod)
values
('Panadol cj 10',20,1.85,1,1,1);



