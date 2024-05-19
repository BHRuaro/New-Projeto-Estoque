package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.TipoMovimentacao;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TipoMovimentacaoDAO extends DAO<TipoMovimentacao>{

        @Override
        public Class<TipoMovimentacao> getEntityClass() {
            return TipoMovimentacao.class;
        }

}
