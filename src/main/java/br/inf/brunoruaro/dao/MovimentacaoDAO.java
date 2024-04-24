package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Movimentacao;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MovimentacaoDAO extends DAO<Movimentacao>{

    @Override
    public Class<Movimentacao> getEntityClass() {
        return Movimentacao.class;
    }

    public Movimentacao find(Integer id) {
        return super.find(id);
    }

    public void add(Movimentacao movimentacao) {
        super.add(movimentacao);
    }

    public void remove(Movimentacao movimentacao) {
        super.remove(movimentacao);
    }

    public Movimentacao update(Movimentacao movimentacao) {
        return super.update(movimentacao);
    }
}
