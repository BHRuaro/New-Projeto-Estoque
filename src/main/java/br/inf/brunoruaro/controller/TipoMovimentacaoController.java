package br.inf.brunoruaro.controller;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import br.inf.brunoruaro.dao.TipoMovimentacaoDAO;
import br.inf.brunoruaro.model.TipoMovimentacao;

@RequestScoped
public class TipoMovimentacaoController extends CrudController<TipoMovimentacao>{

    @Inject
    TipoMovimentacaoDAO tipoMovimentacaoDAO;

    @PostConstruct
    public void init() {
        this.dao = tipoMovimentacaoDAO;
    }

    @Override
    public Integer getId(TipoMovimentacao entity) {
        return entity.getTipoMovimentacaoId();
    }
}
