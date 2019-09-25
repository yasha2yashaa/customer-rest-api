package com.hsbc.customerrestapi.controllers;

public interface Controller<E> {
    E add(E entity);
    E getById(long id);
}
