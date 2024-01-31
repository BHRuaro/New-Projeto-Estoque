package br.inf.brunoruaro.model;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TipoMovimentacaoDAO extends DAO<TipoMovimentacao>{

        @Override
        public Class<TipoMovimentacao> getEntityClass() {
            return TipoMovimentacao.class;
        }

        public TipoMovimentacao find(Integer id) {
            return super.find(id);
        }

        public void add(TipoMovimentacao tipoMovimentacao) {
            super.add(tipoMovimentacao);
        }

        public void remove(TipoMovimentacao tipoMovimentacao) {
            super.remove(tipoMovimentacao);
        }

        public TipoMovimentacao update(TipoMovimentacao tipoMovimentacao) {
            return super.update(tipoMovimentacao);
        }
}
