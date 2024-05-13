package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Item;
import jakarta.enterprise.context.RequestScoped;
import org.glassfish.jaxb.core.v2.model.core.ID;

@RequestScoped
public class ItemDAO extends DAO<Item, ID>{

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
