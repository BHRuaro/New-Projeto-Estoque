package br.inf.brunoruaro.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import br.inf.brunoruaro.dao.TipoMovimentacaoDAO;
import br.inf.brunoruaro.model.TipoMovimentacao;

@RequestScoped
public class TipoMovimentacaoController {

    @Inject
    TipoMovimentacaoDAO tipoMovimentacaoDAO;

    public Integer tipoMovimentacaoCreate(TipoMovimentacao tipoMovimentacao){
        tipoMovimentacaoDAO.add(tipoMovimentacao);

        return tipoMovimentacao.getTipoMovimentacaoId();
    }

    public TipoMovimentacao tipoMovimentacaoFind(Integer tipoMovimentacaoId){
        return tipoMovimentacaoDAO.find(tipoMovimentacaoId);
    }

    public void tipoMovimentacaoRemove(Integer tipoMovimentacaoId){
        TipoMovimentacao tipoMovimentacao = tipoMovimentacaoDAO.find(tipoMovimentacaoId);
        tipoMovimentacaoDAO.remove(tipoMovimentacao);
    }

    public TipoMovimentacao tipoMovimentacaoUpdate(TipoMovimentacao tipoMovimentacao){
        return tipoMovimentacaoDAO.update(tipoMovimentacao);
    }

    public Object tipoMovimentacaoList(){
        return tipoMovimentacaoDAO.list();
    }

}
