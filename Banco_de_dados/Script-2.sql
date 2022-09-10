##double(6,2) quer dizer 6 algarismos antes da virgula e dois depois
##char a string é tratada com o tamanho da capacidade máxima da variável, independente do tamanho real
##varchar a string é tratada com exatamente o tamanho ideal dentro da capacidade máxima

create database livraria;

use livraria;

create table item(
	id bigint not null primary key auto_increment,
	titulo varchar(100) not null,
	genero varchar(100) not null,
	valor_venda decimal(6,2) not null,
	valor_locacao decimal(6,2) not null,
	emprestado bit(1) not null default(b'0')
);

create table dvd(
	id bigint not null primary key auto_increment,
	diretor varchar(250) not null,
	duracao time not null,
	ano_lancamento int not null,
	id_item bigint not null, 
	foreign key (id_item) references item(id)
);


create table livro(
	id bigint not null primary key auto_increment,
	autor varchar(250) not null,
	qtde_paginas int not null,
	ano_publicacao int not null,
	edicao int not null,
	id_item bigint not null, 
	foreign key (id_item) references item(id)
);

create table Avaliacao(
	id bigint not null primary key auto_increment,
	nome_avaliador varchar(100) not null,
	nota decimal(6,2) not null,
	comentario varchar(250),
	id_item bigint not null,
	foreign key (id_item) references item(id)
);

create table genero(
	id bigint not null primary key auto_increment,
	nome varchar(50) not null
);

create table genero_item(
	id_genero bigint not null,
	id_item bigint not null,
	primary key (id_genero, id_item),
	foreign key (id_genero) references genero(id),
	foreign key (id_item) references item(id)
);

insert into genero (nome) values ('Sci-fi');
insert into genero (nome) values ('Ação');
insert into genero (nome) values ('Aventura');

alter table item drop column genero;

insert into item(titulo, valor_venda, valor_locacao) 
values('Stars Wars: EP IV - Uma Nova Esperança', 25.6, 8.0);

insert into genero_item (id_genero, id_item)
values(2,1);

insert into genero_item (id_genero, id_item)
values(3,1);

insert into dvd(diretor, duracao, ano_lancamento, id_item)
values('George Lucas', '2:01', 1977, 1);

insert into item(titulo, valor_venda, valor_locacao) 
values('Homens de Preto', 56.0, 8.0);

insert into dvd(diretor, duracao, ano_lancamento, id_item)
values('Barry Sonnenfeld', '1:38', 1997, 2);

insert into genero_item (id_genero, id_item)
values(2,2);

insert into genero(nome) values('Comédia');

insert into genero_item (id_genero, id_item)
values(4,2);

insert into item(titulo, valor_venda, valor_locacao) 
values('Shrek', 48.25, 8.0);

insert into dvd(diretor, duracao, ano_lancamento, id_item)
values('Andrew Adamson, Vicky Jenson', '1:29', 2001, 3);

insert into genero_item (id_genero, id_item)
values(4,3);

insert into genero(nome) values('Fantasia');

insert into genero_item (id_genero, id_item)
values(5,3);

insert into item(titulo, valor_venda, valor_locacao) 
values('Eu robô', 74.0, 12.0);

insert into livro(autor, qtde_paginas, ano_publicacao, edicao, id_item)
values('Isaac Asimov', 253, 1950, 1, 4);

insert into genero_item (id_genero, id_item)
values(1,4);

insert into item(titulo, valor_venda, valor_locacao) 
values('O Código Da Vinci', 56.8, 12.0);

insert into livro(autor, qtde_paginas, ano_publicacao, edicao, id_item)
values('Den Brown', 432, 2004, 1, 5);

insert into genero(nome) values('Romance Policial');
insert into genero(nome) values('Suspense');

insert into genero_item (id_genero, id_item)
values(6,5);

insert into genero_item (id_genero, id_item)
values(7,5);

insert into item(titulo, valor_venda, valor_locacao) 
values('A Batalha do Apocalipse', 45.3, 12.0);

insert into livro(autor, qtde_paginas, ano_publicacao, edicao, id_item)
values('Eduardo Spohr', 586, 2010, 1, 6);

insert into genero_item (id_genero, id_item)
values(5,6);

select i.* from item i
inner join genero_item gi on gi.id_item = i.id 
inner join genero g on g.id = gi.id_genero 
where g.nome =  'Fantasia';

drop database livraria;
