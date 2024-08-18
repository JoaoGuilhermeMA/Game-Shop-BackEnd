package com.example.demo.controller;

import com.example.demo.domain.Jogo;
import com.example.demo.service.custom.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/interno")
public class AdminController {

    @Autowired
    private JogoService jogoService;

    @PostMapping
    public ResponseEntity<?> salvarJogo(@RequestBody JogoDTO jogoDTO, @RequestPart("file") MultipartFile[] files){
        try {
            Jogo jogo = jogoDTO.toJogo();
            jogoService.create(jogo);
            return ResponseEntity.status(HttpStatus.CREATED).body("JogoController salvo com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar o jogo: " + e.getMessage());
        }
    }
}
