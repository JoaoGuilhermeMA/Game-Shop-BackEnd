package com.example.demo.repository;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {

    @Query("SELECT p FROM Plataforma p WHERE p.id = ?1")
    public Plataforma buscaPorId(Long id);
}

