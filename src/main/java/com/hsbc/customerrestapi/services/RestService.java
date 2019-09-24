package com.hsbc.customerrestapi.services;

public interface RestService<E> {
    void add(E entity);
    E getById(long id);
}
