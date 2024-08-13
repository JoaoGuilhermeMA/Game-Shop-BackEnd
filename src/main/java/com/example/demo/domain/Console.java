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
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "console_id")
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = true)
    private String descricao;

    @Column(nullable = false)
    private String categoria;

    @ManyToMany(mappedBy = "consoles")
    private List<Pedidos> pedidos;

}
