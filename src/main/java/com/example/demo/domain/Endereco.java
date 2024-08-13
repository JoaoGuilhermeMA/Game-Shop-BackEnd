package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rua;
    private String complemento;
    private String numero;
    private String cidade;
    private String bairro;
    private String estado;
    private String pais;
}

