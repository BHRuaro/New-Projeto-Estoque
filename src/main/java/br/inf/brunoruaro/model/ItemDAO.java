package br.inf.brunoruaro.model;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ItemDAO extends DAO<Item>{

    @Override
    public Class<Item> getEntityClass() {
        return Item.class;
    }

    public Item find(Integer id) {
        return super.find(id);
    }

    public void add(Item item) {
        super.add(item);
    }

    public void remove(Item item) {
        super.remove(item);
    }

    public Item update(Item item) {
        return super.update(item);
    }
}
