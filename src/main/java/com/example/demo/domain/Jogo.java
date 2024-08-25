package com.example.demo.domain;

import com.example.demo.domain.generics.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE jogo SET deleted_at = CURRENT_TIMESTAMP where id=?")
@SQLRestriction("deleted_at is null")
public class Jogo extends AbstractEntity {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = true)
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "jogo_categoria", joinColumns = @JoinColumn(name = "jogo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    @JsonIgnore
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

