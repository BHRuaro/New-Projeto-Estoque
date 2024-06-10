package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.error.ApiException;
import br.inf.brunoruaro.model.Operador;
import br.inf.brunoruaro.dao.OperadorDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

import java.util.List;

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

    public boolean operadorLogin(Operador operador) throws ApiException {
        List<Operador> operadores = super.list();
        for (Operador o : operadores) {
            if (o.getNome().equals(operador.getNome()) && o.getSenha().equals(operador.getSenha())) {
                return true;
            }
        }
        return false;
    }

}

