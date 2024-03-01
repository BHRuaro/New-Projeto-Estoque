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
    @Inject
    HistoricoMovimentacaoController historicoMovimentacaoController ;
    @Inject
    ItemController itemController;

    public Integer movimentacaoCreate(Movimentacao movimentacao){
        int validacao = itemController.validaQuantidadeEstoque(movimentacao);
        if (validacao == 0) {
            movimentacaoDAO.add(movimentacao);
            itemController.controlaQuantidadeEstoque(movimentacao);
            historicoMovimentacaoController.adicionaHistoricoMovimentacoes(movimentacao);
            return movimentacao.getMovimentacaoId();
        } else if(validacao == -1){
            return -1;
        } else if (validacao == -2){
            return -2;
        } else if (validacao == -3) {
            return -3;
        } else {
            return 0;
        }
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
