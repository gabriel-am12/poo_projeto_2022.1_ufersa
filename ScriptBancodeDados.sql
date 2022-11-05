 #Mostrar todos os banco de dados do programa
show databases;

#Caso exista um banco de dados parecido anteriormente
#drop  database dbgeradordeprovas;

#Comando para criar um banco de dados novo
create database dbgeradordeprovas;

#Comando para usar um banco de dados novo
use dbgeradordeprovas;

#Esse usuario sera usado para conectar o banco de dados
create user if not exists 'geradordeprovas'@'localhost' identified by 'geradordeprovas1234';

#fornecendo o acesso do usuario para o banco de dados
grant all privileges on dbgeradordeprovas.* to geradordeprovas@localhost;

create table tbusuario(
	id int auto_increment primary key,
    	email varchar(50),
    	nome varchar(50),
    	usuario varchar(15) not null unique,
    	senha varchar(15) not null
);

#insert into tbusuario(email,nome,usuario,senha) values("joaosales911@gmail.com","João Vitor Fernandes de Sales","joaosales","joao1234");


show tables;

create table if not exists tbdisciplina(
	id int auto_increment primary key,
	codigo varchar(10) not null,
   	nome varchar(20) not null,
    	assuntos varchar(100),
    	data_criacao timestamp default current_timestamp
);

#criação da tabela de questoes ainda não executei o codigo [rascunho

#criação da tabela de questões objetivas
create table if not exists tbquestaoobj(
	id int auto_increment primary key,
    	codigo varchar(10),
    	enunciado text not null,
    	tipo int,
    	assuntos varchar(100) not null,
    	data_criacao timestamp default current_timestamp,
    	dificuldade int,
    	fk_disciplina int not null,
    	foreign key (fk_disciplina) references tbdisciplina(id),
	opcao01 varchar(500) not null,
    	opcao02 varchar(500) not null,
    	opcao03 varchar(500) not null,
    	opcao04 varchar(500) not null,
    	opcao05 varchar(500),
    	resposta varchar(500) not null
);

#criação da tabela de questões subjetivas
create table if not exists tbquestaosub(
	id int auto_increment primary key,
	codigo varchar(10),
    	enunciado text not null,
    	tipo int,
    	assuntos varchar(100) not null,
    	data_criacao timestamp default current_timestamp,
    	dificuldade int,
    	fk_disciplina int not null,
    	foreign key (fk_disciplina) references tbdisciplina(id),
	resposta varchar(500) not null
);

#Criação da tabela prova
create table if not exists tbprova(
	id int auto_increment primary key,
	nome varchar(20) not null,
    	enunciado text not null,
	data_questao timestamp default current_timestamp,
    	fk_questaoobj int not null,
    	fk_questaosub int not null,
    	fk_disciplina int not null,
    	foreign key(fk_questaoobj) references tbquestaoobj(id),
    	foreign key(fk_questaosub) references tbquestaosub(id),
	foreign key(fk_disciplina) references tbdisciplina(id)
);
