package br.inf.brunoruaro.model;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.util.List;

public abstract class DAO<T> {

    @Inject
    EntityManager em;

    public abstract Class<T> getEntityClass();

    public T find(Integer id) {
        return this.em.find(getEntityClass(), id);
    }

    public List<T> list() {
        return em.createQuery("select a from " + getEntityClass().getName() + " a ", getEntityClass()).getResultList();
    }

    public void add(T t) {
        em.persist(t);
        em.flush();
    }

    public void remove(T t) {
        em.remove(t);
    }

    public T update(T t) {
        return em.merge(t);
    }
}

