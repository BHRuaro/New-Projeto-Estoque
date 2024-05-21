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
            return dao.find(validId(id));
        } catch (Exception e) {
            throw new ApiException("Erro ao buscar a entidade");
        }
    }

    @Override
    public T update(T entity) throws ApiException {

        if (entity == null) {
            throw new ApiException("Informe uma entidade válida");
        } else if (dao.find(getId(entity)) == null) {
            throw new ApiException("Entidade não encontrada");
        }

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
            T entity = dao.find(validId(id));
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

    @Override
    public List<T> getByName(String name) throws ApiException {
        try {
            return dao.getByName(name);
        } catch (Exception e) {
            throw new ApiException("Erro ao buscar a entidade");
        }
    }

    @Override
    public abstract Integer getId(T entity);

    private Integer validId(Integer id) throws ApiException {
        if (id == null || id <= 0) {
            throw new ApiException("Informe um id válido");
        } else if (dao.find(id) == null) {
            throw new ApiException("Entidade não encontrada");
        }
        return id;
    }
}