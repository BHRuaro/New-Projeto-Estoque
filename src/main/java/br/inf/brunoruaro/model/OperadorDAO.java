package br.inf.brunoruaro.model;

import jakarta.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class OperadorDAO extends DAO<Operador> {
    @Override
    public Class<Operador> getEntityClass() {
        return Operador.class;
    }

    public Operador find(Integer id) {
        return super.find(id);
    }

    public void add(Operador operador) {
        super.add(operador);
    }

    public void remove(Operador operador) {
        super.remove(operador);
    }

    public Operador update(Operador operador) {
        return super.update(operador);
    }

    public boolean login(Operador operador) {
        List<Operador> operadores = super.list();
        for (Operador o : operadores) {
            if (o.getNome().equals(operador.getNome()) && o.getSenha().equals(operador.getSenha())) {
                return true;
            }
        }
        return false;
    }
}