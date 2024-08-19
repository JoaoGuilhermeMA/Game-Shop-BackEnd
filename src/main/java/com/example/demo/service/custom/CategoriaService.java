package com.example.demo.service.custom;

import com.example.demo.domain.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends GenericService<Categoria, Long, CategoriaRepository>{

    @Autowired
     private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        super(repository);
    }

    @Override
    public Categoria listById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

