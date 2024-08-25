package com.example.demo.dto;

import com.example.demo.controller.EnderecoController;
import com.example.demo.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponseDto extends RepresentationModel<EnderecoResponseDto> {
    private String rua;
    private String complemento;
    private String numero;
    private String cidade;
    private String bairro;
    private String estado;
    private String pais;

    public void addLinks(Endereco endereco){
        this.add(linkTo(EnderecoController.class).slash(endereco.getId()).withSelfRel());
    }
}
