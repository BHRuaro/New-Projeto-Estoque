package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.model.Operador;
import br.inf.brunoruaro.dao.OperadorDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class OperadorController extends CrudController<Operador> {

    @Inject
    OperadorDAO operadorDAO;

    @PostConstruct
    public void init() {
        this.dao = operadorDAO;
    }

    @Override
    public Integer getId(Operador entity) {
        return entity.getOperadorId();
    }

    public boolean operadorLogin(Operador operador){
        return operadorDAO.login(operador);
    }

}

