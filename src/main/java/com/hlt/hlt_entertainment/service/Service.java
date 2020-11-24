package com.hlt.hlt_entertainment.service;

public interface Service<T> {
    Iterable<T> findAll();

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
