package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidosRequestDto extends RepresentationModel<PedidosRequestDto> {
    private List<Long> jogos;  // IDs dos jogos
    private Long usuario;  // ID do usuário
    private Date data;
    private Double preco;
}