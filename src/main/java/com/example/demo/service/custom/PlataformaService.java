package com.example.demo.service.custom;

import com.example.demo.domain.Plataforma;
import com.example.demo.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlataformaService extends GenericService<Plataforma, Long, PlataformaRepository>{

    @Autowired
    private PlataformaRepository repository;

    public PlataformaService(PlataformaRepository repository) {
        super(repository);
    }

    @Override
    public Plataforma listById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
