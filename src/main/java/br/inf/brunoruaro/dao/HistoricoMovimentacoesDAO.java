package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.HistoricoMovimentacoes;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class HistoricoMovimentacoesDAO extends DAO<HistoricoMovimentacoes>{

    @Override
    public Class<HistoricoMovimentacoes> getEntityClass() {
        return HistoricoMovimentacoes.class;
    }
}
