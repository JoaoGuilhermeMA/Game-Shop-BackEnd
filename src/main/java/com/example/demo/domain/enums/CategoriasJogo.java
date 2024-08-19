package com.example.demo.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CategoriasJogo {
    ACAO("Ação"),
    AVENTURA("Aventura"),
    FPS("Fps"),
    ESTRATEGIA("Estratégia"),
    SIMULACAO("Simulação"),
    ESPORTES("Esportes"),
    CORRIDA("Corrida"),
    PUZZLE("Puzzle"),
    HORROR("Horror"),
    MUSICAL_RITMO("Música ou ritmo"),
    PARTY_GAMES("Party games"),
    SANDBOX("Sandbox"),
    MMO("MMO"),
    MOBA("MOBA"),
    BATTLE_ROYALE("Battle royale"),
    MMORPG("MMORPG"),
    STEALTH("Stealth"),
    SURVIVAL("Survival"),
    ROGUELIKE("Roguelike"),
    VISUAL_NOVEL("Visual novel"),
    IDLE_GAMES("Idle games"),
    EDUCATIONAL("Educational"),
    ART_GAMES("Art games"),
    METROIDVANIA("Metroidvania"),
    GACHA("Gacha"),
    HACK_AND_SLASH("Hack and slash");

    private String denominacao;

    CategoriasJogo(String s) {
        this.denominacao = s;
    }

    @JsonCreator
    public static CategoriasJogo fromString(String descricao) {
        for (CategoriasJogo categoria : values()) {
            if (categoria.denominacao.equalsIgnoreCase(descricao)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Unknown categoria: " + descricao);
    }

    @JsonValue
    public String getDenominacao() {
        return denominacao;
    }
}
