package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.dao.HistoricoCadastrosDAO;
import br.inf.brunoruaro.model.*;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.sql.Date;
import java.util.List;

@RequestScoped
public class HistoricoCadastrosController {

    @Inject
    HistoricoCadastrosDAO historicoCadastrosDAO;

    public Integer createHistoricoCadastros(HistoricoCadastros historicoCadastros){
        historicoCadastrosDAO.add(historicoCadastros);
        return historicoCadastros.getHistoricoCadId();
    }

    public HistoricoCadastros findHistoricoCadastros(Integer historicoId){
        return historicoCadastrosDAO.find(historicoId);
    }

    public void removeHistoricoCadastros(Integer historicoId){
        HistoricoCadastros historicoCadastros = historicoCadastrosDAO.find(historicoId);
        historicoCadastrosDAO.remove(historicoCadastros);
    }

    public List<HistoricoCadastros> listHistoricoCadastros(){
        return historicoCadastrosDAO.list();
    }

    public HistoricoCadastros updateHistoricoCadastros(HistoricoCadastros historicoCadastros){
        return historicoCadastrosDAO.update(historicoCadastros);
    }

    public void adicionaCadastro(Object object){
        if(object instanceof Usuario usuario){

            insereUsuarioHistoricoCadastro(usuario);
        }else if(object instanceof Item item){

            insereItemHistoricoCadastro(item);
        } else if (object instanceof Fornecedor fornecedor){

            insereFornecedorHistoricoCadastro(fornecedor);
        } else{
            throw new RuntimeException("Erro ao adicionar cadastro");
        }
    }


    public void insereUsuarioHistoricoCadastro(Usuario usuario){
        HistoricoCadastros historicoCadastros = new HistoricoCadastros();

        historicoCadastros.setUsuario(usuario);
        historicoCadastros.setData(new Date(System.currentTimeMillis()));
        historicoCadastros.setOperador(usuario.getOperador());

        createHistoricoCadastros(historicoCadastros);
    }

    public void insereItemHistoricoCadastro(Item item){
        HistoricoCadastros historicoCadastros = new HistoricoCadastros();

        historicoCadastros.setItem(item);
        historicoCadastros.setData(new Date(System.currentTimeMillis()));
        historicoCadastros.setOperador(item.getOperador());

        createHistoricoCadastros(historicoCadastros);
    }

    public void insereFornecedorHistoricoCadastro(Fornecedor fornecedor){
        HistoricoCadastros historicoCadastros = new HistoricoCadastros();

        historicoCadastros.setFornecedor(fornecedor);
        historicoCadastros.setData(new Date(System.currentTimeMillis()));
        historicoCadastros.setOperador(fornecedor.getOperador());

        createHistoricoCadastros(historicoCadastros);
    }
}
