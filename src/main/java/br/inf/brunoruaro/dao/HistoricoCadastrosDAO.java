package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.HistoricoCadastros;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class HistoricoCadastrosDAO extends DAO<HistoricoCadastros>{

    @Override
    public Class<HistoricoCadastros> getEntityClass() {
        return HistoricoCadastros.class;
    }

}
