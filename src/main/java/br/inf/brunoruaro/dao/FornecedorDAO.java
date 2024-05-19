package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Fornecedor;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class FornecedorDAO extends DAO<Fornecedor>{

    @Override
    public Class<Fornecedor> getEntityClass() {
        return Fornecedor.class;
    }
}
