package br.inf.brunoruaro.dao;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

import java.io.Serializable;
import java.util.List;

public abstract class DAO<T, ID extends Serializable> {

    @Inject
    EntityManager em;

    public abstract Class<T> getEntityClass();

    public T find(Integer id) throws PersistenceException {
        return this.em.find(getEntityClass(), id);
    }

    public List<T> list() throws PersistenceException{
        return em.createQuery("select a from " + getEntityClass().getName() + " a ", getEntityClass()).getResultList();
    }

    public void add(T t) throws PersistenceException{
        em.persist(t);
        em.flush();
    }

    public void remove(T t) throws PersistenceException{
        em.remove(t);
    }

    public T update(T t) throws PersistenceException{
        return em.merge(t);
    }
}

