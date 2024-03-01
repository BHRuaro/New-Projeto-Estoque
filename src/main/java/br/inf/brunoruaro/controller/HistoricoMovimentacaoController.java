package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.HistoricoMovimentacoes;
import br.inf.brunoruaro.model.HistoricoMovimentacoesDAO;
import br.inf.brunoruaro.model.Movimentacao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.sql.Date;
import java.util.List;

@RequestScoped
public class HistoricoMovimentacaoController {

    @Inject
    HistoricoMovimentacoesDAO historicoMovimentacoesDAO;

    public Integer createHistoricoMovimentacoes(HistoricoMovimentacoes historicoMovimentacoes){
        historicoMovimentacoesDAO.add(historicoMovimentacoes);
        return historicoMovimentacoes.getHistoricoMovId();
    }

    public HistoricoMovimentacoes findHistoricoMovimentacoes(Integer historicoId){
        return historicoMovimentacoesDAO.find(historicoId);
    }

    public void removeHistoricoMovimentacoes(Integer historicoId){
        HistoricoMovimentacoes historicoMovimentacoes = historicoMovimentacoesDAO.find(historicoId);
        historicoMovimentacoesDAO.remove(historicoMovimentacoes);
    }

    public List<HistoricoMovimentacoes> listHistoricoMovimentacoes(){
        return historicoMovimentacoesDAO.list();
    }

    public HistoricoMovimentacoes updateHistoricoMovimentacoes(HistoricoMovimentacoes historicoMovimentacoes){
        return historicoMovimentacoesDAO.update(historicoMovimentacoes);
    }

    public void adicionaHistoricoMovimentacoes(Movimentacao movimentacao) {

        HistoricoMovimentacoes historicoMovimentacoes = new HistoricoMovimentacoes();

        historicoMovimentacoes.setMovimentacao(movimentacao);
        historicoMovimentacoes.setData(new Date(System.currentTimeMillis()));
        historicoMovimentacoes.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
        historicoMovimentacoes.setItem(movimentacao.getItem());
        historicoMovimentacoes.setQuantidade(movimentacao.getQuantidade());
        historicoMovimentacoes.setOperador(movimentacao.getOperador());

        if (movimentacao.getTipoMovimentacao().getTipoMovimentacaoId() == 2) {
            historicoMovimentacoes.setUsuario(movimentacao.getUsuario());
        }

        historicoMovimentacoesDAO.add(historicoMovimentacoes);
    }
}
