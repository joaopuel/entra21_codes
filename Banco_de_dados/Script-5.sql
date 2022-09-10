alter table livro drop column id;
alter table livro add constraint livro_pk primary key (id_item);

alter table dvd drop column id;
alter table dvd add constraint dvd_pk primary key (id_item);

insert into avaliacao(nome_avaliador, nota, comentario, id_item)
values('João', 8.5, 'Aceitável', 1);