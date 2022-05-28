-- verificacion si la base de datos existe
drop database if exists FunkoStore;

-- creacion de la base de datos
create database FunkoStore;

use FunkoStore;



-- creacion de tablas
create table tb_cliente(
cod_cli int(5) not null,
nom_cli varchar(50) not null,
ape_cli varchar(50) not null,
fec_nac_cli date not null,
email_cli varchar(70) not null,
dni_cli char(8) not null,
tel_cli char(9) not null,
dir_cli varchar(150) not null,
distrito  varchar(50) not null
);

create table tb_tipo_pago(
cod_tip_pag char(5) not null,
nom_tip_pag varchar(50) not null,
desc_tip_pag varchar(100) not null,
estado char(1) not null
);

create table tb_categoria(
cod_cat char(5) not null,
nom_cat varchar(50) not null,
desc_cat varchar(100) not null
);

create table tb_producto(
cod_prod char(5) not null,
nom_prod varchar(50) ,
desc_prod varchar(100) ,
cod_cat char(5) not null,
stock int not null,
precio decimal(6,2) not null
);

create table tb_rol(
cod_rol char(5) not null,
nom_rol varchar(50) not null,
desc_rol varchar(100) not null
);

create table tb_personal(
cod_per char(5) not null,
nom_per varchar(50) not null,
ape_per varchar(50) not null,
fec_nac_per date null,
email_per varchar(100) not null,
dni_per int (8) not null,
tel_per char(9) not null,
dir_per varchar(150) not null,
cod_rol char(5) not null
);

create table tb_usuario(
cod_usua  int auto_increment,
nom_usua varchar(15),
ape_usua varchar(25),
usr_usua char(45) NOT NULL unique,
cla_usua char(100),
fna_usua  date  null,
primary key (cod_usua)
);

create table tb_boleta(
nro_bol int auto_increment primary key,
cod_per char(5) not null,
cod_cli char(5) not null,
cod_tip_pag char(5) not null,
total decimal(6,2) not null,
fecha_reg datetime not null
);

create table tb_deta_boleta(
nro_bol int not null,
cod_prod char(5) not null,
cantidad int not null,
precio decimal(6,2) not null,
total decimal(6,2) not null
);

create table tb_menu(
cod_menu char(5) not null,
nom_menu varchar(50) not null,
desc_menu varchar(100) not null,
icono_menu varchar(150) not null,
ord_menu int not null,
ruta_menu varchar(250) not null,
estado char(1) not null
);

create table tb_permiso_usuario(
cod_rol char(5) not null,
cod_menu char(5) not null,
estado char(1) not null 
);

-- contraints de tablas
alter table tb_cliente add constraint PK_tbcliente_cod_cli primary key (cod_cli);

alter table tb_tipo_pago add constraint PK_tb_tipo_pago_cod_cat primary key (cod_tip_pag);
alter table tb_tipo_pago add constraint CHK_tb_tipo_pago_estado check (estado in('A', 'I') );

alter table tb_categoria add constraint PK_tb_categoria_cod_cat primary key (cod_cat);


alter table tb_producto add constraint PK_tb_producto_cod_prod primary key (cod_prod);



alter table tb_rol add constraint PK_tb_rol_cod_rol primary key (cod_rol);


alter table tb_personal add constraint PK_tb_personal_cod_per primary key (cod_per);

alter table tb_personal add constraint FK_tb_personal_cod_rol foreign key (cod_rol) references tb_rol (cod_rol);




-- alter table tb_boleta add constraint PK_tb_boleta_nro_bol primary key (nro_bol);

alter table tb_boleta add constraint FK_tb_boleta_cod_tip_pag foreign key (cod_tip_pag) references tb_tipo_pago (cod_tip_pag);


alter table tb_deta_boleta add constraint FK_tb_deta_boleta_nro_bol foreign key (nro_bol) references tb_boleta (nro_bol);


alter table tb_menu add constraint PK_tb_menu_cod_menu primary key (cod_menu);
alter table tb_menu add constraint CHK_tb_menu_estado check (estado in('A', 'I') );

alter table tb_permiso_usuario add constraint FK_tb_permiso_usuario_cod_rol foreign key (cod_rol) references tb_rol (cod_rol);
alter table tb_permiso_usuario add constraint FK_tb_permiso_usuario_cod_menu foreign key (cod_menu) references tb_menu (cod_menu);
alter table tb_permiso_usuario add constraint CHK_tb_permiso_usuario_estado check (estado in('A', 'I') );




-- insert tb_menu
insert into tb_menu values('MEN01', 'Mantenimiento', 'Pagina principal','fas fa-store-alt', 1, '', 'A');
insert into tb_menu values('MEN02', 'Ventas', 'Modulo de ventas', 'fas fa-cash-register', 2, 'vent', 'A');
insert into tb_menu values('MEN03', 'Boleta', 'Modulo de visualizar boletas', 'fas fa-receipt', 3, 'Bol?optPeticion=l', 'A');
insert into tb_menu values('MEN04', 'Reporte', 'Modulo de reporte', 'fas fa-book', 4, 'repo?optPeticion=l', 'A');
insert into tb_menu values('MEN05', 'Soporte', 'Modulo de soporte', 'fas fa-users', 5, 'Soporte.jsp', 'A');


-- insert tb_rol
insert into tb_rol values('ROL01', 'Administrador', 'Administra todos los modulos del dashboard');
insert into tb_rol values('ROL02', 'Vendedor', 'Encargado solo de vender');


-- insert tb_personal 
insert into tb_personal values('001', 'Luis', 'Pereda', curdate(), 'luis@gmail.com', 74543018, '928317977', 'Av. Benavides 1223, Primer Piso', 'ROL01');
insert into tb_personal values('002', 'Sunny', 'Jurado', curdate(), 'sunny@gmail.com', 15975364, '987654321', 'Av. Benavides 1223, Primer Piso', 'ROL02');
insert into tb_personal values('003', 'Jose', 'Medina', curdate(), 'jose@gmail.com', 45678908, '951357456', 'Av. Benavides 1223, Primer Piso', 'ROL01');
insert into tb_personal values('004', 'Stephanie', 'Lindegger', curdate(), 'Stephanie@gmail.com', 45678908, '951357456', 'Av. Benavides 1223, Primer Piso', 'ROL01');
insert into tb_personal values('005', 'Sebastian', 'Aranda', curdate(), 'sebastian@gmail.com', 45678908, '951357456', 'Av. Benavides 1223, Primer Piso', 'ROL01');


-- insert tb_usuario
insert into tb_usuario values (null,'Admin', 'Admin','admin@hotmail.com', 'admin', curdate());




-- insert tb_permiso_usuario
insert into tb_permiso_usuario values('ROL01', 'MEN01', 'A');
insert into tb_permiso_usuario values('ROL01', 'MEN02', 'A');
insert into tb_permiso_usuario values('ROL01', 'MEN03', 'A');
insert into tb_permiso_usuario values('ROL01', 'MEN04', 'A');
insert into tb_permiso_usuario values('ROL01', 'MEN05', 'A');
insert into tb_permiso_usuario values('ROL02', 'MEN02', 'A');


-- insert tb_clientes
insert into tb_cliente values(01, 'Jose', 'Medina','2000-09-04','CLI01@hotmail.com','25896314', '961123456','AV_Sol','Chorrillos');
insert into tb_cliente values(02, 'Juan', 'Merino','1998-08-08','CLI02@hotmail.com','98774152', '912345678','AV_Miraflores','Miraflores');
insert into tb_cliente values(03, 'Luis', 'Perez','1999-07-08','CLI03@hotmail.com','74175378', '961654789','AV_Comas','Comas');
insert into tb_cliente values(04, 'Ana', 'Moreno','2000-08-09','CLI04@hotmail.com','78941537', '961269712','AV_El sol','Barranco');
insert into tb_cliente values(05, 'Karina', 'Sanchez','1999-12-05','CLI05@hotmail.com','78945621', '961123567','AV_solares','La Molina');
insert into tb_cliente values(06, 'Martin', 'Ramirez','1997-11-09','CLI06@hotmail.com','45628936', '961586123','AV_Andromeda','Surco');
insert into tb_cliente values(07, 'Pilar', 'Malca','2001-03-05','CLI07@hotmail.com','12398754', '961874125','AV_Miraflores','MIraflores');
insert into tb_cliente values(08, 'Geraldine', 'Garay','1999-09-10','CLI08@hotmail.com','15896394', '966235896','AV_Matellino','Chorrillos');
insert into tb_cliente values(09, 'Alejandra', 'Pinelo','2000-02-11','CLI09@hotmail.com','12896311', '981269312','AV_Chorrilos','Chorrillos');
insert into tb_cliente values(10, 'Andrea', 'Castro','2000-05-12','CLI10@hotmail.com','32896313', '912659766','AV_Gaviotas','San Isidro');


-- insert tb_categoria
insert into tb_categoria values(01, "Marvel", 'Superheroes');
insert into tb_categoria values(02, 'Naruto', 'Nijas');
insert into tb_categoria values(03, 'Dragon BAll', 'Guerreros Z');
insert into tb_categoria values(04, 'DC', 'Superheroes');


-- insert tb_producto
insert into tb_producto values( 01, 'FUNKO Capitan America','Superheroes',1,'20','70.00');
insert into tb_producto values(02, 'FUNKO Iron Man', 'Superheroes',1,'12','70.00');
insert into tb_producto values( 03, 'FUNKO Spiderman', 'Superheroes',1,'1','70.00');
insert into tb_producto values( 04, 'FUNKO Naruto', 'Nijas',2,'3','70.00');
insert into tb_producto values(05, 'FUNKO Sasuke', 'Nijas',2,'12','70.00');
insert into tb_producto values(06, 'FUNKO Sakura', 'Nijas',2,'3','70.00');   
insert into tb_producto values( 07, 'FUNKO Goku', 'Guerreros Z',3,'25','70.00');
insert into tb_producto values(08, 'FUNKO Gohan', 'Guerreros Z',3,'24','70.00');
insert into tb_producto values(09, 'FUNKO Vegeta', 'Guerreros Z',3,'11','70.00');
insert into tb_producto values(10, 'FUNKO Flash', 'Superheroes',4,'1','70.00');
insert into tb_producto values(11, 'FUNKO Superman', 'Superheroes',4,'6','70.00');
insert into tb_producto values(12, 'FUNKO Aquaman ', 'Superheroes',4,'15','70.00');

-- insert tb_tipo_pago
insert into tb_tipo_pago values('TP001', 'EFECTIVO', 'PAGO EN EFECTIVO', 'A');


select c.nom_cat as categoria ,count(*) as producto,sum(stock) as total,max(stock) as mayor_stock, min(stock) as menor_stock
from tb_producto as p
inner join tb_categoria as c
on p.cod_cat= c.cod_cat
group by c.cod_cat
