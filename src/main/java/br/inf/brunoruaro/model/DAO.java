package br.inf.brunoruaro.model;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

public abstract class DAO<T> {

    @Inject
    EntityManager em;

    public abstract Class<T> getEntityClass();

    @Transactional
    public T find(Integer id) {
        return this.em.find(getEntityClass(), id);
    }

    @Transactional
    public List<T> list() {
        return em.createQuery("select a from " + getEntityClass().getName() + " a ", getEntityClass()).getResultList();
    }

    @Transactional
    public void add(T t) {
        em.persist(t);
    }

    @Transactional
    public void remove(T t) {
        em.remove(t);
    }

    @Transactional
    public T update(T t) {
        return em.merge(t);
    }
}

