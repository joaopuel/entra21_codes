## Cria um banco de dados
/*create database tasklist;*/

##Usa banco de dados criado
/*use tasklist;*/


##CRUD - cread read update delete
create table tarefa(
	id bigint not null primary key auto_increment,
	titulo varchar(50) not null,
	descricao varchar(150),
	completa bit(1) not null default(b'0')
);

create table checklist_item(
	id bigint not null primary key auto_increment,
	nome varchar(50) not null,
	cap_max int not null
);

alter table tarefa add column id_lista bigint not null;

alter table checklist_item rename to lista;

alter table tarefa add constraint FK_LISTA_TAREFA foreign key (id_lista) references lista(id);

create table checklist_item(
	id bigint not null primary key auto_increment,
	titulo varchar(50) not null,
	descricao varchar(150)
);

create table cheklist(
	id_tarefa bigint not null,
	id_checklist_item bigint not null,
	completa bit(1) not null default(b'0'),
	foreign key (id_tarefa) references tarefa(id),
	foreign key (id_checklist_item) references checklist_item(id),
	primary key (id_tarefa, id_checklist_item)
	
);

select * from lista;

insert into lista(nome, cap_max)
values('Afazeres', 10);

insert into tarefa(titulo, descricao, id_lista)
values('Lavar a louça', null, 1);

insert into tarefa(titulo, descricao, id_lista)
values('Molhar plantas', 'ATENÇÃO: utilizar o borrifador
para as plantas sensíveis', 1);

insert into tarefa(titulo, descricao, id_lista)
values('Estudar JAVA', null, 1);

select * from tarefa;

insert into lista(nome)
values('Jogatina');

insert into tarefa(titulo, descricao, id_lista)
values('Ordem paranormal - 1800h', null, 2);

update tarefa set completa = 1 where id = 2;
update lista set cap_max = 10 where id = 1;

delete from tarefa where id_lista = 2; ##Remove todas as tarefas relacionadas a lista 2
delete from lista where id = 2;##Só é possível excluir a lista quando não houver tarefas nela

insert into lista(nome, cap_max) values('Afazeres de Casa', 5);
insert into lista(nome, cap_max) values('Atividades da Faculdade', 10);
insert into lista(nome) values('Projetos do Trabalho');

##Afazeres de Casa
insert into tarefa(titulo, descricao, id_lista) values('Lavar a louça', null, 4);
insert into tarefa(titulo, descricao, id_lista) values('Lavar a roupa', null, 4);
insert into tarefa(titulo, descricao, id_lista) values('Arrumar o quarto', null, 4);
insert into tarefa(titulo, descricao, id_lista) values('Fazer a janta', null, 4);
insert into tarefa(titulo, descricao, id_lista) values('Alimentar a calopsita', 'Cuidado que ela bica', 4);

##Atividades da Faculdade
insert into tarefa(titulo, descricao, id_lista) values('Trabalho microeconomia', 'Não esquece as referências', 5);
insert into tarefa(titulo, descricao, id_lista) values('Estudar Modelagem de Sistemas', null, 5);
insert into tarefa(titulo, descricao, id_lista) values('Relatório de Eletrônica', null, 5);
insert into tarefa(titulo, descricao, id_lista) values('Estudar Eletricidade Industrial', null, 5);
insert into tarefa(titulo, descricao, id_lista) values('Testar microcontrolador', null, 5);

##Projetos do Trabalho
insert into tarefa(titulo, descricao, id_lista) values('Enviar e-mail para o chefe', null, 6);
insert into tarefa(titulo, descricao, id_lista) values('Terminar projeto', null, 6);
insert into tarefa(titulo, descricao, id_lista) values('Fazer relatório', null, 6);
insert into tarefa(titulo, descricao, id_lista) values('Revisar falas apresentação', null, 6);
insert into tarefa(titulo, descricao, id_lista) values('Revisar problemas para reunião', null, 6);
