package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.HistoricoCadastros;
import jakarta.enterprise.context.RequestScoped;
import org.glassfish.jaxb.core.v2.model.core.ID;

@RequestScoped
public class HistoricoCadastrosDAO extends DAO<HistoricoCadastros, ID>{

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
