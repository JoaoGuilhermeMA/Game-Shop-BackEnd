package com.example.demo.domain;

import com.example.demo.domain.enums.CategoriasJogo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoriasJogo categoriasJogo;

    @ManyToMany(mappedBy = "categorias", fetch = FetchType.LAZY)
    private List<Jogo> jogos;
}
