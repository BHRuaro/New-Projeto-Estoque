package br.inf.brunoruaro.model;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

@Dependent
public class DAO<T> {

    @PersistenceContext(unitName = "bruno-ruaro")
    EntityManager em;
    private final Class<T> classe;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }

    @Transactional
    public T find(Integer id) {
        return this.em.find(classe, id);
    }

    @Transactional
    public List<T> list() {
        return em.createQuery("select a from " + classe.getName() + "a", classe).getResultList();
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

