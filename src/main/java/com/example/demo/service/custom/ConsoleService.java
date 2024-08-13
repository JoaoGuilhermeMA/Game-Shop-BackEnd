package com.example.demo.service.custom;

import com.example.demo.domain.Console;
import com.example.demo.repository.ConsoleRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService extends GenericService<Console, Long, ConsoleRepository> {

    private ConsoleRepository repository;

    public ConsoleService(ConsoleRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Console listById(Long id){
        return repository.buscaPorId(id);
    }
}
