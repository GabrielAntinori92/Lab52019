create database TP2;
use TP2;

create table words(
	id int unsigned auto_increment,
    word varchar(50) not null,
    
    constraint pk_id_words primary key(id)
);

create table winners(
	id int unsigned auto_increment,
    name varchar(20) not null,
    word varchar(50) not null,
    
    constraint pk_id_winners primary key(id)
);

INSERT INTO `words` (`word`) VALUES ("sed"),("felis"),("orci"),("pede"),("ante"),("montes");
INSERT INTO `words` (`word`) VALUES ("vel"),("vivamus"),("erat"),("maecenas"),("sollicitudin"),("scelerisque"),("nec"),("vulputate"),("tristique");
INSERT INTO `words` (`word`) VALUES ("sem"),("turpis"),("vehicula"),("semper"),("commodo"),("magna"),("sit"),("euismod"),("dapibus");
INSERT INTO `words` (`word`) VALUES ("integer"),("adipiscing"),("tempor"),("cursus"),("consequat"),("mus"),("feugiat"),("tortor"),("malesuada");


select word from words;