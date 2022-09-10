create database livraria;

use livraria;

select i.* from item i
inner join genero_item gi on gi.id_item = i.id 
inner join genero g on g.id = gi.id_genero 
where g.nome =  'Fantasia';

select i.* from item i
inner join dvd d on d.id_item = i.id;

select i.* from item i
left join dvd d on d.id_item = i.id;

select i.* from item i
right join dvd d on d.id_item = i.id;

select i.* from item i
left join dvd d on d.id_item = i.id
where d.id_item is null;

select i.* from item i
right join dvd d on d.id_item = i.id
where i.id is null;

/*
select i.* from item i
full outer join dvd d on d.id_item = i.id;
*/

select i.titulo, max(i.valor_venda)
from item i
join dvd d on d.id_item = i.id 
group by i.titulo;

select i.titulo, count(i.id)
from item i
join dvd d on d.id_item = i.id 
group by i.titulo;

select max(i.valor_venda)
from item i
join dvd d on d.id_item = i.id;

select sum(i.valor_venda)
from item i
join dvd d on d.id_item = i.id;

select i.titulo, sum(i.valor_venda)
from item i
join dvd d on d.id_item = i.id
group by i.titulo;

insert into genero_item (id_genero, id_item)
values((select g.id from genero g where g.nome = 'Sci-fi'),1);

create table franquia(
	id bigint not null primary key auto_increment,
	nome varchar(100) not null
);

delete from genero_item where (id_genero = 1 and id_item =1);

alter table item add column id_franquia bigint;

alter table item add foreign key (id_franquia) references franquia(id);

insert into item(titulo, valor_venda, valor_locacao) 
values('Shreck 2', 43.7, 8.0);

-- update item set titulo = 'Shreck 2' where id = 7;

insert into dvd(diretor, duracao, ano_lancamento, id_item)
values('Andrew Adamson, Vicky Jenson', '1:29', 2001, (select i.id from item i where i.titulo = 'Shreck 2'));

update dvd set duracao = '1:32' where id = 4;
update dvd set ano_lancamento = 2004 where id = 4;
update dvd set diretor = 'Andrew Adamson, Kelly Asbury, Conrad Vernon' where id = 4;

insert into genero_item (id_genero, id_item)
values((select g.id from genero g where g.nome='Fantasia'),7);

insert into genero_item (id_genero, id_item)
values((select g.id from genero g where g.nome='Comédia'),7);

insert into franquia (nome) values('Shreck');

-- like 'Shreck' vai atualizar os títulos que forem exatamente iguais a 'Shreck'
-- like 'Shreck%' títulos que começam com 'Shreck'
-- like '%Shreck' títulos que terminam com 'Shreck'
-- like '%Shreck%' títulos que contém 'Shreck' em algum lugar

update item set id_franquia = 1 where titulo like 'Shreck%';

select f.nome, sum(i.valor_venda)
from item i
join dvd d on d.id_item = i.id
left join franquia f on f.id = i.id_franquia 
group by f.nome;

select f.nome, count(i.valor_venda)
from item i
join dvd d on d.id_item = i.id
left join franquia f on f.id = i.id_franquia 
group by f.nome;

select f.nome, count(i.valor_venda)
from item i
join livro l on l.id_item = i.id
left join franquia f on f.id = i.id_franquia 
group by f.nome;

select i.*
from item i
join dvd d on d.id_item = i.id
where id_franquia is null;

select d.*
from dvd d
join item i on i.id = d.id_item
where i.id_franquia is null;

select l.autor, l.ano_publicacao 
from livro l
where l.ano_publicacao = (select max(l.ano_publicacao) from livro l);

select l.autor, l.ano_publicacao from livro l
order by l.ano_publicacao desc limit 1;

select l.* from livro l
order by l.ano_publicacao desc limit 1;

select i.titulo, l.autor, l.ano_publicacao from livro l
inner join item i on i.id = l.id_item 
order by l.ano_publicacao desc limit 1;

select i.titulo, l.autor, l.ano_publicacao from livro l
inner join item i on i.id = l.id_item 
order by l.ano_publicacao limit 1;

-- order by ** desc para ordem descendente
-- order by ** desc para ordem ascendente

select sum(i.valor_venda), sum(i.valor_venda)/count(i.id) from item i;

select avg(valor_venda) from item;

select i.titulo, i.valor_venda from item i
join dvd d on d.id_item = i.id 
where i.valor_venda = (select max(i.valor_venda) from item i inner join dvd d on d.id_item = i.id);

select i.titulo, i.valor_venda from item i
join dvd d on d.id_item = i.id 
order by i.valor_venda desc limit 1;

select g.nome, count(i.id) from item i
inner join genero_item gi on gi.id_item = i.id 
inner join genero g on g.id = gi.id_genero 
group by g.nome
order by 2 desc limit 1; -- O 2 quer dizer o campo 2, count(i.id)

select i.titulo, g.nome from item i
inner join genero_item gi on gi.id_item = i.id 
inner join genero g on g.id = gi.id_genero 
order by g.nome;


