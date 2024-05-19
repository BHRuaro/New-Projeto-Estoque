package br.inf.brunoruaro.controller;

import br.inf.brunoruaro.error.ApiException;

import java.util.List;

public interface ICrudController<T> {
    Integer create(T entity) throws ApiException;
    T find(Integer id) throws ApiException;
    T update(T entity) throws ApiException;
    void delete(Integer id) throws ApiException;
    List<T> list() throws ApiException;
}
