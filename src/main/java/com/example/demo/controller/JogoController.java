package com.example.demo.controller;

import com.example.demo.domain.Jogo;
import com.example.demo.domain.Plataforma;
import com.example.demo.dto.JogoRequestDto;
import com.example.demo.dto.JogoResponseDto;
import com.example.demo.service.custom.JogoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/jogos/")
@AllArgsConstructor
public class JogoController {

    private final JogoService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<JogoResponseDto> listAll(){
        return service.listAll().stream().map(this::convertToDto).collect(toList());
    }

    @PostMapping
    public ResponseEntity<JogoResponseDto> create(@RequestBody JogoRequestDto jogo) {

        Jogo created = service.create(convertToEntity(jogo));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<JogoResponseDto> listById(@PathVariable("id") Long id) {

        Jogo p = service.listById(id);
        JogoResponseDto dto = mapper.map(p, JogoResponseDto.class);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<JogoResponseDto> update(@RequestBody JogoRequestDto requestDto, @PathVariable("id") Long id) {

        try {
            Jogo j = service.listById(id);
        } catch (Exception e) {
            return this.create(requestDto);
        }

        Jogo JogoUpdated = service.update(mapper.map(requestDto, Jogo.class), id);
        return ResponseEntity.ok(convertToDto(JogoUpdated));
    }

    private JogoResponseDto convertToDto(Jogo created) {
        JogoResponseDto pessoaResponseDto = mapper.map(created, JogoResponseDto.class);
        pessoaResponseDto.addLinks(created);
        return pessoaResponseDto;
    }

    private Jogo convertToEntity(JogoRequestDto jogo) {
        Jogo entityJogo = mapper.map(jogo, Jogo.class);
        Plataforma entityPlataforma = mapper.map(jogo.getPlataforma(), Plataforma.class);
        entityJogo.setPlataforma(entityPlataforma);
        return entityJogo;
    }
}
