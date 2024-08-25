package com.example.demo.dto;

import com.example.demo.controller.EnderecoController;
import com.example.demo.controller.UsuarioController;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDto extends RepresentationModel<UsuarioResponseDto> {
    private String nome;
    private String email;
    private Endereco endereco;
    private String telefone;
    private String role;

    public void addLinks(Usuario usuario) {
        this.add(linkTo(UsuarioController.class).slash(usuario.getId()).withSelfRel());
        // Se você quiser adicionar um link para o endereço, faça o seguinte:
        if (usuario.getEndereco() != null) {
            this.add(linkTo(EnderecoController.class).slash(usuario.getEndereco().getId()).withRel("endereco"));
        }
    }
}
