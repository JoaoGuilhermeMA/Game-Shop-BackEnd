package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoRequestDto extends RepresentationModel<EnderecoRequestDto> {
    private String rua;
    private String complemento;
    private String numero;
    private String cidade;
    private String bairro;
    private String estado;
    private String pais;
}
