create table clientes(
matricula integer primary key,
nome varchar(40),
email varchar(50),
saldo decimal(10,2)
);

create table relatorio(
codRelatorio serial primary key,
matricula integer,
codFuncionario integer,
codProduto integer,
data varchar(10)
);

create table produtos(
codProduto serial primary key,
nome varchar(40),
tipo varchar(20),
preco decimal(10,2)
);

create table funcionarios(
codFuncionario serial primary key,
nome varchar(40),
telefone varchar(15)
);

create table login(
codLogin serial primary key,
matricula integer,
codFuncionario integer,
usuario varchar(30),
senha varchar(30),
permissao integer
);

--alter table login add constraint fk_codClienteLogin foreign key(matricula) references clientes(matricula);
--alter table login add constraint fk_codFuncionarioLogin foreign key(codFuncionario) references funcionarios(codFuncionario);
--alter table relatorio add constraint fk_RelatorioCodCliente foreign key(matricula) references clientes(matricula);
--alter table relatorio add constraint fk_RelatorioCodFuncionario foreign key(codFuncionario) references funcionarios(codFuncionario);

insert into funcionarios(nome,telefone) values
('Pedro Silva', '(51)8495-5689');

insert into clientes(matricula,nome,email,saldo) values
('631310448', 'Guilherme Silveira','guilherme@daew.com.br',500.00),
('6666','oooo','ooo@hotmail.com', 20.00);

insert into login(permissao, usuario, senha, codFuncionario, matricula) values
(2,'Guilherme', '123456',null, 631310448),
(1,'Pedro', '123456',1, null),
(2,'oooo', '123456', null, 6666);

insert into produtos(nome, tipo, preco) values
('Capuccino', 'Bebidas', '2.50'),
('Salgado', 'Alimentos', '4.00');

insert into relatorio(matricula,codfuncionario,codproduto, data) values
(6666,1,1,'23/06/2013'),
(6666,1,2,'23/06/2013'),
(6666,1,2,'15/07/2013'),
(631310448,1,2,'23/06/2013');


select * from clientes;

select * from funcionarios;

select * from relatorio

select * from login;

select * from login where usuario='Guilherme' and senha= '123456';