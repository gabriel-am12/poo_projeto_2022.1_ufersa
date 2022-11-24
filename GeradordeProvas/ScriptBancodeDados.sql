 #Mostrar todos os banco de dados do programa
show databases;

#drop  database dbgeradordeprovas;

#Comando para criar um banco de dados novo
create database dbgeradordeprovas;

#Comando para usar um banco de dados novo
use dbgeradordeprovas;

#Esse usuario sera usado para conectar o banco de dados
create user if not exists 'geradordeprovas'@'localhost' identified by 'geradordeprovas1234';

#fornecendo o acesso do usuario para o banco de dados
grant all privileges on dbgeradordeprovas.* to geradordeprovas@localhost;


create table tb_usuario(
	id int auto_increment primary key,
    email varchar(50),
    nome varchar(50),
    login varchar(15) not null unique,
    senha varchar(15) not null
);

#insert into tb_usuario(email,nome,login,senha) values("joaosales911@gmail.com","João Vitor","joaosales","joao1234");
select * from tb_usuario;

show tables;

create table if not exists tb_disciplina(
	id int auto_increment primary key,
	codigo varchar(10) not null,
    nome text not null,
    assuntos text,
    data_criacao timestamp default current_timestamp
);

#criação da tabela de questoes ainda não executei o codigo [rascunho

#criação da tabela de questões objetivas
create table if not exists tb_questaoobj(
	id int auto_increment primary key,
    codigo varchar(10),
    enunciado text not null,
    tipo int,
    assuntos text not null,
    data_criacao timestamp default current_timestamp,
    dificuldade varchar(15),
    fk_disciplina int,
     disciplina text,
    foreign key (fk_disciplina) references tb_disciplina(id),
	opcao01 text not null,
    opcao02 text not null,
    opcao03 text not null,
    opcao04 text not null,
    opcao05 text,
    resposta text not null
);

#criação da tabela de questões subjetivas
create table if not exists tb_questaosub(
	id int auto_increment primary key,
	codigo varchar(10),
    enunciado text not null,
    tipo int,
    assuntos text not null,
    data_criacao timestamp default current_timestamp,
    dificuldade varchar(15),
    fk_disciplina int,
	disciplina text,
    foreign key (fk_disciplina) references tb_disciplina(id),
	resposta text not null
);

#Criação da tabela prova
create table if not exists tb_prova(
	id int auto_increment primary key,
	nome varchar(20),
    enunciado text,
	data_criacao timestamp default current_timestamp,
    semestre varchar(10),
    nivelUm varchar(5),
    nivelDois varchar(5),
    nivelTres varchar(5),
    codigo varchar(15),
    disciplina text,
    fk_questaoobj int,
    fk_questaosub int,
    fk_disciplina int,
    foreign key(fk_questaoobj) references tb_questaoobj(id),
    foreign key(fk_questaosub) references tb_questaosub(id),
	foreign key(fk_disciplina) references tb_disciplina(id)
);

select * from tb_usuario;

select * from tb_disciplina;

select * from tb_questaoobj;
UPDATE tb_questaoobj SET enunciado="enunciado" WHERE id=2;
UPDATE tb_questaoobj SET codigo="COD",enunciado="DASDS",assuntos="SA",dificuldade="DSA",resposta="W221",disciplina="DWD",opcao01="DWDW",opcao02="2121",opcao03="3232",opcao04="32323",opcao05="3232" WHERE id=1;

select * from tb_questaosub;

select * from tb_prova;

#O codigo abaixo tras as informações de 2 tabelas juntas 