package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.dao.DAO;
import br.inf.brunoruaro.error.ApiException;
import jakarta.inject.Inject;
import java.util.List;

public abstract class CrudController<T> implements ICrudController<T> {

    @Inject
    protected DAO<T> dao;

    @Override
    public Integer create(T entity) throws ApiException {
        try {
            dao.add(entity);

            return getId(entity);
        } catch (Exception e) {
            throw new ApiException("Erro ao adicionar entidade");
        }
    }

    @Override
    public T find(Integer id) throws ApiException {
        try {
            return dao.find(id);
        } catch (Exception e) {
            throw new ApiException("Erro ao buscar a entidade");
        }
    }

    @Override
    public T update(T entity) throws ApiException {
        try {
            dao.update(entity);

            return entity;
        } catch (Exception e) {
            throw new ApiException("Erro ao atualizar a entidade");
        }
    }

    @Override
    public void delete(Integer id) throws ApiException {
        try {
            T entity = dao.find(id);
            dao.remove(entity);
        } catch (Exception e) {
            throw new ApiException("Erro ao remover a entidade");
        }
    }

    @Override
    public List<T> list() throws ApiException {
        try {
            return dao.list();
        } catch (Exception e) {
            throw new ApiException("Erro ao listar as entidades");
        }
    }

    protected abstract Integer getId(T entity);

}