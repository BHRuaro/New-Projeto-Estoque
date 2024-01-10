package br.inf.brunoruaro.model;

import jakarta.inject.Inject;

import java.util.List;
import java.util.HashMap;

public class OperadorDAO {

    @Inject
    private final DAO<Operador> dao;

    public OperadorDAO() {
        this.dao = new DAO<>(Operador.class);
    }

    public Operador find(Integer id) {
        return this.dao.find(id);
    }

    public void add(Operador operador) {
        this.dao.add(operador);
    }

    public void remove(Operador operador) {
        this.dao.remove(operador);
    }

    public Operador update(Operador operador) {
        return this.dao.update(operador);
    }

    public List<Operador> list() {
        return this.dao.list();
    }

    public static boolean login(HashMap<String, String> parameters) {
        String user = parameters.get("user");
        String password = parameters.get("password");
        OperadorDAO operadorDAO = new OperadorDAO();
        List<Operador> operadores = operadorDAO.list();
        for (Operador operador : operadores) {
            if (operador.getNome().equals(user) && operador.getSenha().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
