package com.example.demo.domain;

import com.example.demo.domain.enums.CategoriasJogo;
import com.example.demo.domain.generics.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private CategoriasJogo categoriasJogo;

    @ManyToMany(mappedBy = "categorias", fetch = FetchType.LAZY)
    private List<Jogo> jogos;
}
