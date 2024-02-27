package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.HistoricoCadastros;
import br.inf.brunoruaro.model.HistoricoCadastrosDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

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
}
