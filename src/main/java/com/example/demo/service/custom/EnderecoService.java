package com.example.demo.service.custom;

import com.example.demo.domain.Endereco;
import com.example.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService extends GenericService<Endereco, Long, EnderecoRepository>{
    private EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Override
    public Endereco listById(Long id) {
        return repository.buscaPorId(id);
    }
}

