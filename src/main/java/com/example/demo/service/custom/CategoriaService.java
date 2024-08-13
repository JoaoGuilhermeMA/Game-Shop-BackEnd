package com.example.demo.service.custom;

import com.example.demo.domain.Categoria;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService extends GenericService<Categoria, Long, CategoriaRepository>{
    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        super(repository);
        this.repository = repository;
    }
    @Override
    public Categoria listById(Long id) {
        return repository.buscaPorId(id);
    }
}
