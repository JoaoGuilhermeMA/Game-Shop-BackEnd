package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlataformaRequestDto extends RepresentationModel<PlataformaRequestDto> {
    private Long id;
    private String nome;
    private String tipo;
    private String parceira;
    private Boolean deletado;
}
