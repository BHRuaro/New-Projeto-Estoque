package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.Movimentacao;
import br.inf.brunoruaro.model.MovimentacaoDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

@RequestScoped
public class MovimentacaoController {

    @Inject
    MovimentacaoDAO movimentacaoDAO;

    public Integer movimentacaoCreate(Movimentacao movimentacao) {
        movimentacaoDAO.add(movimentacao);
        return movimentacao.getMovimentacaoId();
    }

    public Movimentacao movimentacaoFind(Integer movimentacaoId){
        return movimentacaoDAO.find(movimentacaoId);
    }

    public void movimentacaoRemove(Integer movimentacaoId){
        Movimentacao movimentacao = movimentacaoDAO.find(movimentacaoId);
        movimentacaoDAO.remove(movimentacao);
    }

    public Movimentacao movimentacaoUpdate(Movimentacao movimentacao){
        return movimentacaoDAO.update(movimentacao);
    }

    public List<Movimentacao> movimentacaoList(){
        return movimentacaoDAO.list();
    }
}
