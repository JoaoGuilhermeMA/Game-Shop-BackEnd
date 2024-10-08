package com.example.demo.service.custom;

import com.example.demo.domain.Jogo;
import com.example.demo.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService extends GenericService<Jogo, Long, JogoRepository> {
    public JogoService(JogoRepository repository) {
        super(repository);
    }
}

