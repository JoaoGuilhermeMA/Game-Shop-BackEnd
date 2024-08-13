package com.example.demo.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoriaConsole {
    DESKTOP("Desktop"),
    XBOX("Xbox"),
    PLAYSTATION("Playstation"),
    NINTENDO("Nintendo");

    private String denominacao;

    CategoriaConsole(String s) {
        denominacao = s;
    }

    public static CategoriaConsole getMetodoAquisicao(int ordinal) {
        switch(ordinal){
            case 1: return CategoriaConsole.DESKTOP;
            case 2: return CategoriaConsole.XBOX;
            case 3: return CategoriaConsole.PLAYSTATION;
            case 4: return CategoriaConsole.NINTENDO;
        }
        return null;
    }

    @JsonCreator
    public static CategoriaConsole getMetodoAquisicao(String descricao) {
        switch(descricao){
            case "Desktop": case "DESKTOP": return CategoriaConsole.DESKTOP;
            case "Xbox": case "XBOX": return CategoriaConsole.XBOX;
            case "Playstation": case "PLAYSTATION": return CategoriaConsole.PLAYSTATION;
            case "Nintendo": case "NINTENDO": return CategoriaConsole.NINTENDO;
        }
        return null;
    }

    @JsonValue
    public String getDenominacao() {return denominacao;}
}
