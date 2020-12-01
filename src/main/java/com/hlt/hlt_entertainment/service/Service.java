package com.hlt.hlt_entertainment.service;

import com.hlt.hlt_entertainment.model.AppRole;
import com.hlt.hlt_entertainment.model.ERole;

import java.util.Optional;

public interface Service<T> {
    Iterable<T> findAll();
    T findById(Long id);
    void save(T model);
    void remove(Long id);
}
