package com.example.demo.dto;

import com.example.demo.controller.CategoriaController;
import com.example.demo.domain.Categoria;
import com.example.demo.domain.enums.CategoriasJogo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponseDto extends RepresentationModel<CategoriaResponseDto> {
    private Long id;
    private CategoriasJogo categoriasJogo;

    public void addLinks(Categoria categoria) {
        this.add(linkTo(CategoriaController.class).slash(categoria.getId()).withSelfRel());
        // Adicione outros links relacionados se necessário
    }
}
