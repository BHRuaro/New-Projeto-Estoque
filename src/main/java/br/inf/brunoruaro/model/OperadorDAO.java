package br.inf.brunoruaro.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.HashMap;

@RequestScoped
public class OperadorDAO extends DAO<Operador>{
    @Override
    public Class<Operador> getEntityClass() {
        return Operador.class;
    }

    public Operador find(Integer id) {
        return this.find(id);
    }

    public void add(Operador operador) {
        this.add(operador);
    }

    public void remove(Operador operador) {
        this.remove(operador);
    }

    public Operador update(Operador operador) {
        return this.update(operador);
    }

    public boolean login(HashMap<String, String> parameters) {
        String user = parameters.get("user");
        String password = parameters.get("password");
        List<Operador> operadores = this.list();
        for (Operador operador : operadores) {
            if (operador.getNome().equals(user) && operador.getSenha().equals(password)) {
                return true;
            }
        }
        return false;
    }
}