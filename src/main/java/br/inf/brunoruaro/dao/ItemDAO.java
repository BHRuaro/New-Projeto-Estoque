package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Item;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ItemDAO extends DAO<Item>{

    @Override
    public Class<Item> getEntityClass() {
        return Item.class;
    }

}
