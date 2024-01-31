package br.inf.brunoruaro.model;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class HistoricoMovimentacoesDAO extends DAO<HistoricoMovimentacoes>{

    @Override
    public Class<HistoricoMovimentacoes> getEntityClass() {
        return HistoricoMovimentacoes.class;
    }

    public HistoricoMovimentacoes find(Integer id) {
        return super.find(id);
    }

    public void add(HistoricoMovimentacoes historicoMovimentacoes) {
        super.add(historicoMovimentacoes);
    }

    public void remove(HistoricoMovimentacoes historicoMovimentacoes) {
        super.remove(historicoMovimentacoes);
    }

    public HistoricoMovimentacoes update(HistoricoMovimentacoes historicoMovimentacoes) {
        return super.update(historicoMovimentacoes);
    }
}
