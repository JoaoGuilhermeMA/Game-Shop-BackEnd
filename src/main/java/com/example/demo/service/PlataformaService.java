package com.example.demo.service;

import com.example.demo.domain.Plataforma;
import com.example.demo.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlataformaService {

    @Autowired
    private PlataformaRepository plataformaRepository;

    public List<Plataforma> listarTodas() {
        return plataformaRepository.findAll();
    }

    public Optional<Plataforma> buscarPorId(Long id) {
        return plataformaRepository.findById(id);
    }

    public Plataforma salvar(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    public void deletar(Long id) {
        plataformaRepository.deleteById(id);
    }
}
