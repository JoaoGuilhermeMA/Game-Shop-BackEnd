package com.example.demo.dtos;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Console;
import com.example.demo.domain.Jogo;
import com.example.demo.domain.Plataforma;

import java.util.ArrayList;
import java.util.List;

public class JogoBuscaDTO {

    private String nome;
    private Double preco;
    private String descricao;
//    private List<Categoria> categorias;
    private String plataforma;
//    private List<Console> consoles;
    private Double desconto;

    public List<JogoBuscaDTO> toJogoBuscaDTO (List<Jogo> jogos){
        List<JogoBuscaDTO> dtoList = new ArrayList<JogoBuscaDTO>();

        for (Jogo jogo : jogos) {
            JogoBuscaDTO dto = new JogoBuscaDTO();
            dto.nome = jogo.getNome();
            dto.preco = jogo.getPreco();
            dto.descricao = jogo.getDescricao();
            dto.desconto = jogo.getDesconto();
            //        this.plataforma = jogo.getPlataforma().getNome();

            dtoList.add(dto);
        }
        return dtoList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
