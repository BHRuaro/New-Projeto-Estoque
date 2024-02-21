package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.Fornecedor;
import br.inf.brunoruaro.model.FornecedorDAO;
import br.inf.brunoruaro.model.Item;
import br.inf.brunoruaro.model.ItemDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class ItemController {

    @Inject
    ItemDAO itemDAO;

    @Inject
    FornecedorDAO fornecedorDAO;

    public Integer itemCreate(Item item){
            Fornecedor fornecedor = fornecedorDAO.find(item.getFornecedor().getFornecedorId());
            item.setFornecedor(fornecedor);
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

    public Object itemList(){
        return itemDAO.list();
    }
}
