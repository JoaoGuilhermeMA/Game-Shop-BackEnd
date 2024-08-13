package com.example.demo.service.custom;

import com.example.demo.domain.Pedidos;
import com.example.demo.repository.PedidosRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService extends GenericService<Pedidos, Long, PedidosRepository>{
    private PedidosRepository repository;

    public PedidosService(PedidosRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Pedidos listById(Long id) {
        return repository.buscaPorId(id);
    }
}

