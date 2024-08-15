package com.example.demo.dtos;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Console;
import com.example.demo.domain.Jogo;
import com.example.demo.domain.Plataforma;
import jakarta.persistence.*;

import java.util.List;

public class JogoDTO {
    private String nome;
    private Double preco;
    private String descricao;
    private List<Categoria> categorias;
    private Plataforma plataforma;
    private List<Console> consoles;
    private Double desconto;

    public Jogo toJogo(){
        Jogo jogo = new Jogo();
        jogo.setNome(nome);
        jogo.setPreco(preco);
        jogo.setDescricao(descricao);
        //categoria
        //plataforma
        //consoles
        if(desconto != null)
            jogo.setDesconto(desconto);

        return jogo;
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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public List<Console> getConsoles() {
        return consoles;
    }

    public void setConsoles(List<Console> consoles) {
        this.consoles = consoles;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
}
