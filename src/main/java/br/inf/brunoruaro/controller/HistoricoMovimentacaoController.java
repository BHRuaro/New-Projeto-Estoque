package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.HistoricoMovimentacoes;
import br.inf.brunoruaro.dao.HistoricoMovimentacoesDAO;
import br.inf.brunoruaro.model.Movimentacao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.sql.Date;

@RequestScoped
public class HistoricoMovimentacaoController extends CrudController<HistoricoMovimentacoes>{

    @Inject
    HistoricoMovimentacoesDAO historicoMovimentacoesDAO;

    @PostConstruct
    public void init() {
        this.dao = historicoMovimentacoesDAO;
    }

    @Override
    public Integer getId(HistoricoMovimentacoes entity) {
        return entity.getHistoricoMovId();
    }

    public void create(Movimentacao movimentacao) throws ApiException{

        try{
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
        }catch (Exception e){
            throw new ApiException("Erro ao criar histórico de movimentação");
        }
    }
}
