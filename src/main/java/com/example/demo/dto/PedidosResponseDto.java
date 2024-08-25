package com.example.demo.dto;

import com.example.demo.controller.JogoController;
import com.example.demo.controller.PedidosController;
import com.example.demo.controller.UsuarioController;
import com.example.demo.domain.Jogo;
import com.example.demo.domain.Pedidos;
import com.example.demo.domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosResponseDto extends RepresentationModel<PedidosResponseDto> {
    private List<Jogo> jogos;
    private Usuario usuario;
    private Date data;
    private Double preco;

    public void addLinks(Pedidos pedidos) {
        this.add(linkTo(PedidosController.class).slash(pedidos.getId()).withSelfRel());
        pedidos.getJogos().forEach(jogo -> {
            this.add(linkTo(JogoController.class).slash(jogo.getId()).withRel("jogo"));
        });
        this.add(linkTo(UsuarioController.class).slash(pedidos.getUsuario().getId()).withRel("usuario"));
    }
}
