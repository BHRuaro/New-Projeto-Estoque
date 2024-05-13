package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.TipoMovimentacao;
import jakarta.enterprise.context.RequestScoped;
import org.glassfish.jaxb.core.v2.model.core.ID;

@RequestScoped
public class TipoMovimentacaoDAO extends DAO<TipoMovimentacao, ID>{

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
