package br.inf.brunoruaro.dao;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public abstract class DAO<T> {

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

    public T getByName(String name) {

        String queryString = "SELECT a FROM " + getEntityClass().getName() + " a WHERE a.nome = :name";

        TypedQuery<T> query = em.createQuery(queryString, getEntityClass());

        query.setParameter("name", name);

        return query.getSingleResult();
    }
}

