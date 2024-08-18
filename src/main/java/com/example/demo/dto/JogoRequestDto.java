package com.example.demo.dto;

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
    private List<Long> categoriaIds;
    private PlataformaRequestDto plataforma;
    private List<Long> consoleIds;
    private Double desconto;
}
