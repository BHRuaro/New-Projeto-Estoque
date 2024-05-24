package br.inf.brunoruaro.controller;


import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Movimentacao;
import br.inf.brunoruaro.dao.MovimentacaoDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class MovimentacaoController extends CrudController<Movimentacao>{

    @Inject
    MovimentacaoDAO movimentacaoDAO;
    @Inject
    HistoricoMovimentacaoController historicoMovimentacaoController ;
    @Inject
    ItemController itemController;

    @PostConstruct
    public void init() { this.dao = movimentacaoDAO; }

    @Override
    public Integer getId(Movimentacao movimentacao) {
        return movimentacao.getMovimentacaoId();
    }


    @Override
    public Integer create(Movimentacao movimentacao) throws ApiException {
        int validacao = itemController.validaQuantidadeEstoque(movimentacao);
        if (validacao == 0) {
            movimentacaoDAO.add(movimentacao);
            itemController.controlaQuantidade(movimentacao);
            historicoMovimentacaoController.create(movimentacao);
            return movimentacao.getMovimentacaoId();
        } else if (validacao == -1){
            throw new ApiException("Quantidade insuficiente em estoque");
        } else if (validacao == -2){
            throw new ApiException("Quantidade excede o limite de movimentação");
        } else if (validacao == -3) {
            throw new ApiException("Quantidade inválida");
        } else {
            throw new ApiException("Erro ao criar movimentação");
        }
    }
}
