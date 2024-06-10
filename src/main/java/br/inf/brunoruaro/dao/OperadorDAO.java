package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Operador;
import jakarta.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class OperadorDAO extends DAO<Operador> {
    @Override
    public Class<Operador> getEntityClass() {
        return Operador.class;
    }


}