package com.hsbc.customerrestapi.controllers;

public interface Controller<E> {
    void add(E entity);
    E getById(Long id);
}
