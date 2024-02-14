package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.Operador;
import br.inf.brunoruaro.model.OperadorDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class OperadorController {

    @Inject
    OperadorDAO operadorDAO;

    public Integer operadorCreate(Operador operador){
        operadorDAO.add(operador);

        return operador.getOperadorId();
    }

    public Operador operadorFind(Integer operadorId){
        return operadorDAO.find(operadorId);
    }

    public void operadorRemove(Integer operadorId){
        Operador operador = operadorDAO.find(operadorId);
        operadorDAO.remove(operador);
    }

    public Operador operadorUpdate(Operador operador){
        return operadorDAO.update(operador);
    }

    public Object operadorList(){
        return operadorDAO.list();
    }

    public boolean operadorLogin(Operador operador){
        return operadorDAO.login(operador);
    }

}

