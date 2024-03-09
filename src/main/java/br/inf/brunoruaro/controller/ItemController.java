package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.Item;
import br.inf.brunoruaro.model.ItemDAO;
import br.inf.brunoruaro.model.Movimentacao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;

@RequestScoped
public class ItemController {

    @Inject
    ItemDAO itemDAO;

    public Integer itemCreate(Item item){
        if(item.getLimiteMovimentacao() == null){
            item.setLimiteMovimentacao(0);
        }
            itemDAO.add(item);
            return item.getItemId();
    }

    public Item itemFind(Integer itemId){
        return itemDAO.find(itemId);
    }

    public void itemRemove(Integer itemId){
        Item item = itemDAO.find(itemId);
        itemDAO.remove(item);
    }

    public Item itemUpdate(Item item){
        return itemDAO.update(item);
    }

    public List<Item> itemList(){
        return itemDAO.list();
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

    public void controlaQuantidadeEstoque(Movimentacao movimentacao){
        Item itemEstoque = itemDAO.find(movimentacao.getItem().getItemId());

        if(movimentacao.getTipoMovimentacao().getTipoMovimentacaoId() == 2){
            itemEstoque.setQuantidade(itemEstoque.getQuantidade() - movimentacao.getQuantidade());
        } else if(movimentacao.getTipoMovimentacao().getTipoMovimentacaoId() == 1){
            itemEstoque.setQuantidade(itemEstoque.getQuantidade() + movimentacao.getQuantidade());
        }
        itemDAO.update(itemEstoque);
    }
}
