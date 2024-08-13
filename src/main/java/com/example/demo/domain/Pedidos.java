package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "pedido_jogo",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "jogo_id")
    )
    private List<Jogo> jogos;

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Double preco;
}
