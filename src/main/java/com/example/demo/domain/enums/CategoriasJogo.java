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
        denominacao = s;
    }

    public static CategoriasJogo getMetodoAquisicao(int ordinal) {
        switch(ordinal){
            case 1: return CategoriasJogo.ACAO;
            case 2: return CategoriasJogo.AVENTURA;
            case 3: return CategoriasJogo.FPS;
            case 4: return CategoriasJogo.ESTRATEGIA;
            case 5: return CategoriasJogo.SIMULACAO;
            case 6: return CategoriasJogo.ESPORTES;
            case 7: return CategoriasJogo.CORRIDA;
            case 8: return CategoriasJogo.PUZZLE;
            case 9: return CategoriasJogo.HORROR;
            case 10: return CategoriasJogo.MUSICAL_RITMO;
            case 11: return CategoriasJogo.PARTY_GAMES;
            case 12: return CategoriasJogo.SANDBOX;
            case 13: return CategoriasJogo.MMO;
            case 14: return CategoriasJogo.MOBA;
            case 15: return CategoriasJogo.BATTLE_ROYALE;
            case 16: return CategoriasJogo.MMORPG;
            case 17: return CategoriasJogo.STEALTH;
            case 18: return CategoriasJogo.SURVIVAL;
            case 19: return CategoriasJogo.ROGUELIKE;
            case 20: return CategoriasJogo.VISUAL_NOVEL;
            case 21: return CategoriasJogo.IDLE_GAMES;
            case 22: return CategoriasJogo.EDUCATIONAL;
            case 23: return CategoriasJogo.ART_GAMES;
            case 24: return CategoriasJogo.METROIDVANIA;
            case 25: return CategoriasJogo.GACHA;
            case 26: return CategoriasJogo.HACK_AND_SLASH;
        }
        return null;
    }

    @JsonCreator
    public static CategoriasJogo getMetodoAquisicao(String descricao) {
        switch(descricao){
            case "Ação": case "ACAO": return CategoriasJogo.ACAO;
            case "Fantasia": case "AVENTURA": return CategoriasJogo.AVENTURA;
            case "Fps": case "FPS": return CategoriasJogo.FPS;
            case "Estratégia": case "ESTRATEGIA": return CategoriasJogo.ESTRATEGIA;
            case "Simulação": case "SIMULACAO": return CategoriasJogo.SIMULACAO;
            case "Esportes": case "ESPORTES": return CategoriasJogo.ESPORTES;
            case "Corrida": case "CORRIDA": return CategoriasJogo.CORRIDA;
            case "Puzzle": case "PUZZLE": return CategoriasJogo.PUZZLE;
            case "Horror": case "HORROR": return CategoriasJogo.HORROR;
            case "Música ou ritmo": case "MUSICAL_RITMO": return CategoriasJogo.MUSICAL_RITMO;
            case "Party games": case "PARTY_GAMES": return CategoriasJogo.PARTY_GAMES;
            case "Sandbox": case "SANDBOX": return CategoriasJogo.SANDBOX;
            case "MMO": return CategoriasJogo.MMO;
            case "MOBA": return CategoriasJogo.MOBA;
            case "Battle royale": case "BATTLE_ROYALE": return CategoriasJogo.BATTLE_ROYALE;
            case "MMORPG": return CategoriasJogo.MMORPG;
            case "Stealth": case "STEALTH": return CategoriasJogo.STEALTH;
            case "Survival": case "SURVIVAL": return CategoriasJogo.SURVIVAL;
            case "Roguelike": case "ROGUELIKE": return CategoriasJogo.ROGUELIKE;
            case "Visual novel": case "VISUAL_NOVEL": return CategoriasJogo.VISUAL_NOVEL;
            case "Idle games": case "IDLE_GAMES": return CategoriasJogo.IDLE_GAMES;
            case "Educational": case "EDUCATIONAL": return CategoriasJogo.EDUCATIONAL;
            case "Art games": case "ART_GAMES": return CategoriasJogo.ART_GAMES;
            case "Metroidvania": case "METROIDVANIA": return CategoriasJogo.METROIDVANIA;
            case "Gacha": case "GACHA": return CategoriasJogo.GACHA;
            case "Hack and slash": case "HACK_AND_SLASH": return CategoriasJogo.HACK_AND_SLASH;
        }
        return null;
    }

    @JsonValue
    public String getDenominacao() {return denominacao;}

}
