package com.giabao.Interface;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    T findById(Integer id);

    T save(T t);

    void remove(Integer id);
}
