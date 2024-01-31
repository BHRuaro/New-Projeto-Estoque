CREATE TABLE operador (
    operador_id serial PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cargo VARCHAR(50),
    data_contratacao DATE,
    salario float,
    senha VARCHAR(100) NOT NULL
);


CREATE TABLE usuario (
    usuario_id serial PRIMARY KEY,
    cpf numeric unique not null,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(100)
);

create table fornecedor(
	fornecedor_id serial primary key,
	nome VARCHAR(255) not null,
	cnpj numeric unique
);

CREATE TABLE item (
    item_id serial PRIMARY KEY,
    fornecedor_id int not null,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    preco_unitario DECIMAL(10, 2),
    quantidade_estoque INT
);

create table movimentacoes (
	movimentacao_id serial primary key,
	tipo_movimentacao_id int not null,
	operador_id int not null,
	usuario_id int,
	item_id int not null,
	quantidade int not null
);

CREATE TABLE tipoMovimentacao (
    tipo_movimentacao_id serial PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);


CREATE TABLE historico_movimentacoes (
	historico_mov_id serial primary key,
	movimentacao_id int NOT NULL,
	data_movimentacao date not NULL,
	tipo_movimentacao_id int not NULL,
	usuario_id int NULL,
	operador_id int not NULL,
	item_id int not NULL,
	quantidade_movimentada int not NULL	
);

create table historico_cadastros (
	historico_cad_id serial primary key,
	usuario_id int,
	item_id int not null,
	operador_id int not null,
	data_cadastro date not null
);
