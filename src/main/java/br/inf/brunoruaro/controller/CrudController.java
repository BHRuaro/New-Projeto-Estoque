package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.dao.DAO;
import jakarta.inject.Inject;
import org.glassfish.jaxb.core.v2.model.core.ID;


public abstract class CrudController<T> implements ICrudController<T> {

    @Inject
    protected DAO<T, ID> dao;

}