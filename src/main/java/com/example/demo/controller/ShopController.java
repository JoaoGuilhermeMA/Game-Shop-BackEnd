package com.example.demo.controller;


import com.example.demo.service.custom.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ShopController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public List<JogoBuscaDTO> carregarJogos(){
       try {
           JogoBuscaDTO jogoBuscaDTO = new JogoBuscaDTO();
           return jogoBuscaDTO.toJogoBuscaDTO(jogoService.listAll());
       }catch (Exception e){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao carregar jogos: " + e.getMessage());
       }
   }

//    @GetMapping("/carregar-consoles")
//    public List<ConsoleBuscaDTO> carregarJogos(){
//        try {
//            JogoBuscaDTO jogoBuscaDTO = new JogoBuscaDTO();
//            return jogoBuscaDTO.toJogoBuscaDTO(jogoService.listAll());
//        }catch (Exception e){
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao carregar jogos: " + e.getMessage());
//        }
//    }

}
