package com.example.demo.service;

import java.util.List;

public interface IService<T, ID> {
    public T create(T entity);
    public List<T> listAll();
    public T listById(ID id);
    public void deleteById(ID id);
    public T update(T entity, ID id);
}
