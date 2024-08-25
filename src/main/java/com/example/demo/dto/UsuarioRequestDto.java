package com.example.demo.dto;

import com.example.demo.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDto extends RepresentationModel<UsuarioRequestDto> {
    private String nome;
    private String email;
    private String senha;
    private Endereco endereco;
    private String telefone;
    private String role;
}