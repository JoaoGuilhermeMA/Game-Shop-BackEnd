package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jogo_id")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = true)
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "jogo_categoria", joinColumns = @JoinColumn(name = "jogo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "jogo_plataforma", joinColumns = @JoinColumn(name = "jogo_id"), inverseJoinColumns = @JoinColumn(name = "plataforma_id"))
    private List<Plataforma> plataformas;

    @Column(nullable = false)
    private String urlImagem;

    @Column(nullable = true)
    private Double desconto;

    @Column(nullable = false)
    private boolean deletado;
}

