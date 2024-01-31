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


}

