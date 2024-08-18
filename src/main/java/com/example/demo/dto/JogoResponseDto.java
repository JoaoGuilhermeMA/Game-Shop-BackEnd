package com.example.demo.dto;

import com.example.demo.controller.PlataformaController;
import com.example.demo.domain.Jogo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import com.example.demo.controller.JogoController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JogoResponseDto extends  RepresentationModel<JogoRequestDto>{
    private String nome;
    private Double preco;
    private String descricao;
    private List<Long> categoriaIds;
    private Long plataformaId;
    private List<Long> consoleIds;
    private Double desconto;

    public void addLinks(Jogo p){
        this.add(linkTo(JogoController.class).slash(p.getId()).withSelfRel());
        this.add(linkTo(PlataformaController.class).slash(p.getId()).withSelfRel());
    }
}
