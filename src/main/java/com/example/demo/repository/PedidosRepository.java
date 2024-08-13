package com.example.demo.repository;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
    @Query("SELECT p FROM Pedidos p WHERE p.id = ?1")
    public Pedidos buscaPorId(Long id);
}

