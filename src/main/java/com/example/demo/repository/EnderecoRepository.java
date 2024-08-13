package com.example.demo.repository;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    @Query("SELECT e FROM Endereco e WHERE e.id = ?1")
    public Endereco buscaPorId(Long id);
}

