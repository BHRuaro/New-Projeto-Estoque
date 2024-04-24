package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.HistoricoCadastros;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class HistoricoCadastrosDAO extends DAO<HistoricoCadastros>{

    @Override
    public Class<HistoricoCadastros> getEntityClass() {
        return HistoricoCadastros.class;
    }

    public HistoricoCadastros find(Integer id) {
        return super.find(id);
    }

    public void add(HistoricoCadastros historicoCadastros) {
        super.add(historicoCadastros);
    }

    public void remove(HistoricoCadastros historicoCadastros) {
        super.remove(historicoCadastros);
    }

    public HistoricoCadastros update(HistoricoCadastros historicoCadastros) {
        return super.update(historicoCadastros);
    }
}
