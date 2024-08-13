package com.example.demo.repository;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Long> {

    @Query("SELECT c FROM Console c WHERE c.id = ?1")
    public Console buscaPorId(Long id);
}
