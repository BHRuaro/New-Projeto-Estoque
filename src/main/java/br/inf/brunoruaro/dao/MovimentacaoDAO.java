package br.inf.brunoruaro.dao;

import br.inf.brunoruaro.model.Movimentacao;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MovimentacaoDAO extends DAO<Movimentacao>{

    @Override
    public Class<Movimentacao> getEntityClass() {
        return Movimentacao.class;
    }
}
