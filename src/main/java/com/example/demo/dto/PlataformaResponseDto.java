package com.example.demo.dto;

import com.example.demo.controller.PlataformaController;
import com.example.demo.domain.Plataforma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlataformaResponseDto extends RepresentationModel<PlataformaResponseDto> {
    private Long id;
    private String nome;
    private String tipo;
    private String parceira;
    private Boolean deletado;

    public void addLinks(Plataforma plataforma) {
        this.add(linkTo(PlataformaController.class).slash(plataforma.getId()).withSelfRel());
    }
}
