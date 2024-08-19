package com.example.demo.dto;

import com.example.demo.controller.JogoController;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.Jogo;
import com.example.demo.domain.Plataforma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogoResponseDto extends RepresentationModel<JogoResponseDto> {
    private String nome;
    private Double preco;
    private String descricao;
    private List<Categoria> categorias;
    private List<Plataforma> plataformas;
    private String urlImagem;
    private Double desconto;

    public void addLinks(Jogo jogo){
        this.add(linkTo(JogoController.class).slash(jogo.getId()).withSelfRel());
    }
}
