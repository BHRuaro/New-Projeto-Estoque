package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Fornecedor;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class FornecedorDAO extends DAO<Fornecedor>{

    @Override
    public Class<Fornecedor> getEntityClass() {
        return Fornecedor.class;
    }

    public Fornecedor find(Integer id) {
        return super.find(id);
    }

    public void add(Fornecedor fornecedor) {
        super.add(fornecedor);
    }

    public void remove(Fornecedor fornecedor) {
        super.remove(fornecedor);
    }

    public Fornecedor update(Fornecedor fornecedor) {
        return super.update(fornecedor);
    }
}
