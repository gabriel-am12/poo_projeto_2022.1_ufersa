 #Mostrar todos os banco de dados do programa
show databases;

#Comando para criar um banco de dados novo
create database dbgeradordeprovas;

#Comando para usar um banco de dados novo
use dbgeradordeprovas;

#para criar um usuario para o banco de dados
create user if not exists 'geradordeprovas'@'localhost' identified by 'geradordeprovas1234';

#fornecendo o acesso do usuario para o banco de dados
grant all privileges on dbgeradordeprovas.* to geradordeprovas@localhost;

#isso ainda não foi testado. Codigo para criação da tabela usuario
create table tb_usuario(
	id_usuario int auto_increment primary key,
    email varchar(50) unique not null,
    usuario varchar(70),
    telefone varchar(15),
    login varchar(15) not null unique,
    senha varchar(20) not null
);

#criação da tabela de disciplina ainda não executei o codigo [rascunho]

show tables;

create table if not exists tb_disciplina(
	codigo int auto_increment,
    nome varchar(20) not null,
    assuntos varchar(100) not null,
    data_disciplina timestamp default current_timestamp,
    constraint id_pk primary key(codigo)
);

#criação da tabela de questoes ainda não executei o codigo [rascunho

#criação da tabela de questões objetivas
create table if not exists tb_questaoobj(
	codigo int auto_increment,
    enunciado text not null,
    tipo int,
    assuntos varchar(100) not null,
    data_questao timestamp default current_timestamp,
    dificuldade varchar(15) not null,
    foreign key (fk_disciplina) references tb_disciplina(id_pk),
    constraint id_pk primary key(codigo),
	opcao01 varchar(500) not null,
    opcao02 varchar(500) not null,
    opcao03 varchar(500) not null,
    opcao04 varchar(500) not null,
    opcao05 varchar(500),
    resposta varchar(500) not null
);

#criação da tabela de questões subjetivas
create table if not exists tb_questaosub(
	codigo int auto_increment,
    enunciado text not null,
    tipo int,
    assuntos varchar(100) not null,
    data_questao timestamp default current_timestamp,
    dificuldade varchar(15) not null,
    foreign key (fk_disciplina) references tb_disciplina(id_pk),
    constraint id_pk primary key(codigo),
	resposta varchar(500) not null
);

#Criação da tabela prova
create table if not exists tb_prova(
	codigo int auto_increment,
	nome varchar(20) not null,
    enunciado text not null,
	data_questao timestamp default current_timestamp,
    foreign key(fk_questaoobj) references tb_questaoobj(id_pk),
    foreign key(fk_questaosub) references tb_questaosub(id_pk),
	foreign key(fk_disciplina) references tb_disciplina(id_pk),
    constraint id_pk primary key(codigo)
);