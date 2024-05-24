package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Item;
import br.inf.brunoruaro.dao.ItemDAO;
import br.inf.brunoruaro.model.Movimentacao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ItemController extends CrudController<Item>{

    @Inject
    ItemDAO itemDAO;

    @Inject
    HistoricoCadastrosController historicoCadastrosController;

    @PostConstruct
    public void init() {
        this.dao = itemDAO;
    }

    @Override
    public Integer getId(Item item) {
        return item.getItemId();
    }

    @Inject
    FornecedorController fornecedorController;


    @Override
    public Integer create(Item item) throws ApiException {

        if(!validaCadastro(item)){
            throw new ApiException("Erro ao validar cadastro");
        }

        if(item.getQuantidade() == null){
            item.setQuantidade(0);
        }

        if(item.getLimiteMovimentacao() == null){
            item.setLimiteMovimentacao(0);
        }

        try {
            itemDAO.add(item);
            historicoCadastrosController.adicionaCadastro(item);

            return item.getItemId();
        }catch (Exception e) {
            throw new ApiException("Erro ao cadastrar item");
        }

    }

    @Override
    public Item update(Item item) throws ApiException {

        if(!validaCadastro(item)){
            throw new ApiException("Erro ao validar cadastro");
        }

        if(item.getQuantidade() == null){
            item.setQuantidade(0);
        }

        if(item.getLimiteMovimentacao() == null){
            item.setLimiteMovimentacao(0);
        }

        try {
            return itemDAO.update(item);
        }catch (Exception e) {
            throw new ApiException("Erro ao atualizar item");
        }
    }

    public boolean validaCadastro(Item item) throws ApiException{
        if(item.getNome() == null || item.getNome().isEmpty()){
            throw new ApiException("Nome do item não pode ser vazio");
        }

        if(item.getFornecedor() == null){
            throw new ApiException("Fornecedor do item não pode ser vazio");
        }else if(fornecedorController.find(item.getFornecedor().getFornecedorId()) == null){
            throw new ApiException("Fornecedor não encontrado");
        }

        return true;
    }

    public Integer validaQuantidadeEstoque(Movimentacao movimentacao){
           Item itemEstoque = itemDAO.find(movimentacao.getItem().getItemId());

        if (movimentacao.getTipoMovimentacao().getTipoMovimentacaoId() == 2 &&
                   movimentacao.getQuantidade() > itemEstoque.getQuantidade()){
            return -1;
        } else if(movimentacao.getTipoMovimentacao().getTipoMovimentacaoId() == 2 &&
                movimentacao.getQuantidade() > itemEstoque.getLimiteMovimentacao() && itemEstoque.getLimiteMovimentacao() > 0){
            return -2;
        } else if (movimentacao.getQuantidade() <= 0){
            return -3;
        } else {
            return 0;
        }
    }

    public void controlaQuantidade(Movimentacao movimentacao){
        Item itemEstoque = itemDAO.find(movimentacao.getItem().getItemId());

        if(movimentacao.getTipoMovimentacao().getTipoMovimentacaoId() == 2){
            itemEstoque.setQuantidade(itemEstoque.getQuantidade() - movimentacao.getQuantidade());
        } else if(movimentacao.getTipoMovimentacao().getTipoMovimentacaoId() == 1){
            itemEstoque.setQuantidade(itemEstoque.getQuantidade() + movimentacao.getQuantidade());
        }
        itemDAO.update(itemEstoque);
    }
}
