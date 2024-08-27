package com.example.demo.controller;

import com.example.demo.domain.Categoria;

import com.example.demo.dto.CategoriaRequestDto;
import com.example.demo.dto.CategoriaResponseDto;
import com.example.demo.service.custom.CategoriaService;
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
@RequestMapping("/categorias/")
@AllArgsConstructor
@CrossOrigin("*")
public class CategoriaController {

    private final CategoriaService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<CategoriaResponseDto> listAll() {
        return service.listAll().stream()
                .map(categoria -> {
                    CategoriaResponseDto dto = convertToDto(categoria);
                    dto.addLinks(categoria);
                    return dto;
                })
                .collect(toList());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CategoriaRequestDto categoriaDto) {
        Categoria created = service.create(convertToEntity(categoriaDto));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.ok("Jogo cadastrado!");
    }


    @GetMapping("{id}")
    public ResponseEntity<CategoriaResponseDto> listById(@PathVariable("id") Long id) {
        Categoria c = service.listById(id);
        CategoriaResponseDto dto = convertToDto(c);
        dto.addLinks(c);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok("Jogo indisponível");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@RequestBody CategoriaRequestDto requestDto, @PathVariable("id") Long id) {
        try {
            Categoria c = service.listById(id);
        } catch (Exception e) {
            this.create(requestDto);
        }
        Categoria categoria = service.update(mapper.map(requestDto, Categoria.class));
        return ResponseEntity.ok("Jogo alterado com sucesso");
    }


    private CategoriaResponseDto convertToDto(Categoria created) {
        CategoriaResponseDto dto = mapper.map(created, CategoriaResponseDto.class);
        return dto;
    }


    private Categoria convertToEntity(CategoriaRequestDto categoriaDto) {
        Categoria categoriaEntity = mapper.map(categoriaDto, Categoria.class);
        return categoriaEntity;
    }

}
