create database TP1;
use TP1;

create table ganadores(
	id int unsigned auto_increment,
	nombre varchar(20) not null,
    resistencia_final int not null,
    
    constraint pk_id_ganadores primary key(id)
); 

select * from ganadores;