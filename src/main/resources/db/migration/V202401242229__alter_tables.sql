ALTER TABLE public.historico_movimentacoes ADD CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES item(item_id);
ALTER TABLE public.historico_movimentacoes ADD CONSTRAINT fk_movimentacao FOREIGN KEY (movimentacao_id) REFERENCES movimentacoes(movimentacao_id);
ALTER TABLE public.historico_movimentacoes ADD CONSTRAINT fk_operador FOREIGN KEY (operador_id) REFERENCES operador(operador_id);
ALTER TABLE public.historico_movimentacoes ADD CONSTRAINT fk_tipo_movimentacao FOREIGN KEY (tipo_movimentacao_id) REFERENCES tipo_movimentacao(tipo_movimentacao_id);
ALTER TABLE public.historico_movimentacoes ADD CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id);

ALTER TABLE public.historico_cadastros ADD CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(usuario_id);
ALTER TABLE public.historico_cadastros ADD CONSTRAINT fk_operador FOREIGN KEY (operador_id) REFERENCES operador(operador_id);
ALTER TABLE public.historico_cadastros ADD CONSTRAINT fk_item FOREIGN KEY (item_id) REFERENCES item(item_id);

alter table public.movimentacoes add constraint fk_usuario foreign key (usuario_id) references usuario(usuario_id);
alter table public.movimentacoes add constraint fk_item foreign key (item_id) references item(item_id);
alter table public.movimentacoes add constraint fk_operador foreign key (operador_id) references operador(operador_id);
alter table public.movimentacoes add constraint fk_tipo_movimentacao foreign key (tipo_movimentacao_id) references tipo_movimentacao(tipo_movimentacao_id);

alter table public.item add constraint fk_fornecedor foreign key (fornecedor_id) references fornecedor(fornecedor_id);
