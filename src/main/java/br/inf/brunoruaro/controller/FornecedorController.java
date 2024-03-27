package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.Fornecedor;
import br.inf.brunoruaro.model.FornecedorDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class FornecedorController {

    @Inject
    FornecedorDAO fornecedorDAO;
    @Inject
    HistoricoCadastrosController historicoCadastrosController;

    public Integer fornecedorCreate(Fornecedor fornecedor){
        fornecedorDAO.add(fornecedor);
        historicoCadastrosController.adicionaCadastro(fornecedor);

        return fornecedor.getFornecedorId();
    }

    public Fornecedor fornecedorFind(Integer fornecedorId){
        return fornecedorDAO.find(fornecedorId);
    }

    public void fornecedorRemove(Integer fornecedorId){
        Fornecedor fornecedor = fornecedorDAO.find(fornecedorId);
        fornecedorDAO.remove(fornecedor);
    }

    public Fornecedor fornecedorUpdate(Fornecedor fornecedor){
        return fornecedorDAO.update(fornecedor);
    }

    public Object fornecedorList(){
        return fornecedorDAO.list();
    }
}
