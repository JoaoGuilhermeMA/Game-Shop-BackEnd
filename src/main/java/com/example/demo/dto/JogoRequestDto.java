package com.example.demo.dto;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Plataforma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JogoRequestDto extends RepresentationModel<JogoRequestDto> {
    private String nome;
    private Double preco;
    private String descricao;
    private List<Long> categorias;  // Alterado para lista de IDs
    private List<Long> plataformas;  // Alterado para lista de IDs
    private String urlImagem;
    private Double desconto;
}
