package com.example.demo.controller;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Jogo;
import com.example.demo.domain.Plataforma;
import com.example.demo.dto.JogoRequestDto;
import com.example.demo.dto.JogoResponseDto;
import com.example.demo.service.custom.CategoriaService;
import com.example.demo.service.custom.JogoService;
import com.example.demo.service.custom.PlataformaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/jogos/")
@AllArgsConstructor
@CrossOrigin("*")
public class JogoController {

    private final JogoService service;
    private final CategoriaService categoriaService;
    private final PlataformaService plataformaService;
    private final ModelMapper mapper;

    @GetMapping
    public List<JogoResponseDto> listAll() {
        return service.listAll().stream()
                .map(jogo -> {
                    JogoResponseDto dto = convertToDto(jogo);
                    dto.addLinks(jogo);
                    return dto;
                })
                .collect(toList());
    }


    @PostMapping
    public ResponseEntity<String> create(@RequestBody JogoRequestDto jogoDto) {
        Jogo created = service.create(convertToEntity(jogoDto));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.ok("Jogo cadastrado!");
    }


    @GetMapping("{id}")
    public ResponseEntity<JogoResponseDto> listById(@PathVariable("id") Long id) {
        Jogo j = service.listById(id);
        JogoResponseDto dto = convertToDto(j);
        dto.addLinks(j);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Jogo indisponível");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@RequestBody JogoRequestDto requestDto, @PathVariable("id") Long id) {
        try {
            Jogo j = service.listById(id);
        } catch (Exception e) {
            this.create(requestDto);
        }
        Jogo JogoUpdated = service.update(mapper.map(requestDto, Jogo.class));
        return ResponseEntity.ok("Jogo alterado com sucesso");
    }


    private JogoResponseDto convertToDto(Jogo created) {
        JogoResponseDto dto = mapper.map(created, JogoResponseDto.class);
        dto.addLinks(created);
        return dto;
    }


    private Jogo convertToEntity(JogoRequestDto jogoDto) {
        Jogo jogoEntity = mapper.map(jogoDto, Jogo.class);

        List<Categoria> categorias = jogoDto.getCategorias().stream()
                .map(id -> categoriaService.listById(id))
                .collect(Collectors.toList());
        jogoEntity.setCategorias(categorias);

        List<Plataforma> plataformas = jogoDto.getPlataformas().stream()
                .map(id -> plataformaService.listById(id))
                .collect(Collectors.toList());
        jogoEntity.setPlataformas(plataformas);

        return jogoEntity;
    }
}