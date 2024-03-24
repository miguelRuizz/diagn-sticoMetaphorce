create database sesiones;
use sesiones;
create table usuario (
	id_usuario int primary key auto_increment, 
    usuario varchar (50), 
    correo varchar (100), 
    telefono varchar (20));

alter table usuario add column contrasenia varchar (50);

create table sesion (
	id_sesion int primary key auto_increment,
    fecha date,
    tema varchar (100));

create table estatus (
	id_estatus int primary key auto_increment,
    estatus varchar (50));

create table asistencia (
	id_usuario int not null,
    id_sesion int not null,
    id_estatus int not null,
    constraint fk_1 foreign key (id_usuario) references usuario (id_usuario),
    constraint fk_2 foreign key (id_sesion) references sesion (id_sesion),
    constraint fk_3 foreign key (id_estatus) references estatus (id_estatus),
    constraint pk_1 primary key (id_usuario, id_sesion));
    
INSERT INTO usuario VALUES
	(1,'Hallie Abernathy','bechtelar.crystal@hotmail.com','09088760063'),
	(2,'Marianne Wolff','maggio.mariana@hotmail.com','729-725-4900'),
	(3,'Filiberto Hettinger','demario.wunsch@hotmail.com','434.159.9654'),
	(4,'Mary Bartell','ahmad85@hotmail.com','156.904.4800x0038'),
	(5,'Prof. Grady Terry DDS','maeve.turcotte@gmail.com','02830751330'),
	(6,'Isom Satterfield II','cristobal80@yahoo.com','639-655-3655'),
	(7,'Ms. Daniela Bailey','luis.schaden@gmail.com','790.028.3860x516'),
	(8,'Waldo Ruecker','o\'reilly.terrill@gmail.com','+91(0)0216482453'),
	(9,'Dr. Jess Rice DDS','ada.barrows@yahoo.com','737.662.5027'),
	(10,'Eulalia Hills PhD','wyman.sadye@gmail.com','1-656-486-7406'),
	(11,'Hans Monahan PhD','pete.mertz@yahoo.com','525-675-2473x00320'),
	(12,'Maximus King','dahlia.lynch@yahoo.com','(511)119-3960x59971'),
	(13,'Melissa Stamm','jerde.jacklyn@yahoo.com','(996)182-1803'),
	(14,'Dr. Juvenal Mayer II','arnoldo.ritchie@gmail.com','1-904-691-3177'),
	(15,'Kristin Will','mertie38@hotmail.com','1-002-491-4290x723');

update usuario set contrasenia="123";

select * from usuario;

insert into sesion (fecha, tema ) values
	("2024-01-07","Bienvenida al curso"),
    ("2024-01-14","Introducción al maya yucateco"),
    ("2024-01-21","Pronombres y verbos esenciales"),
    ("2024-01-28","Conjugaciones de los verbos regulares"),
    ("2024-02-04","Alfabeto y pronunciación"),
    ("2024-02-11","Consonantes y vocales mayas"),
    ("2024-02-11","Vocabulario básico"),
    ("2024-02-18","Números mayas"),
    ("2024-02-25","Tiempos verbales y sufijos"),
    ("2024-03-03","Examen de certificación de nivel básico");
    
select * from sesion;

insert into estatus (estatus) values
	("Asistió"),
    ("No Asistió");

select * from estatus;

insert into asistencia values
	(1,1,1),
    (1,2,1),
    (1,3,1),
    (1,4,2),
    (1,5,1),
    (1,6,1),
    (1,7,1),
    (1,8,1),
    (1,9,1),
    (1,10,1),
    (2,1,2),
    (2,2,1),
    (2,3,1);
    
SELECT u.usuario, s.tema, s.fecha, e.estatus FROM usuario u
	JOIN asistencia a ON a.id_usuario = u.id_usuario
    JOIN sesion s ON s.id_sesion = a.id_sesion
    JOIN estatus e ON e.id_estatus = a.id_estatus
ORDER BY u.usuario, s.fecha;