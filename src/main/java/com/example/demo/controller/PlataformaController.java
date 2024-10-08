package com.example.demo.controller;

import com.example.demo.domain.Plataforma;
import com.example.demo.dto.PlataformaRequestDto;
import com.example.demo.dto.PlataformaResponseDto;
import com.example.demo.service.custom.PlataformaService;
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
@RequestMapping("/plataformas/")
@AllArgsConstructor
@CrossOrigin("*")
public class PlataformaController {

    PlataformaService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<PlataformaResponseDto> listAll(){
        return service.listAll().stream().map(this::convertToDto).collect(toList());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PlataformaRequestDto plataforma) {

        Plataforma created = service.create(convertToEntity(plataforma));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.ok("Plataforma cadastrada!");
    }

    @GetMapping("{id}")
    public ResponseEntity<PlataformaResponseDto> listById(@PathVariable("id") Long id) {

        Plataforma p = service.listById(id);
        PlataformaResponseDto dto = mapper.map(p, PlataformaResponseDto.class);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> update(@RequestBody PlataformaRequestDto requestDto, @PathVariable("id") Long id) {

        try {
            Plataforma p = service.listById(id);
        } catch (Exception e) {
            this.create(requestDto);
        }
        requestDto.setId(id);
        Plataforma p = convertToEntity(requestDto);
        service.update(p);
        return ResponseEntity.ok("Plataforma atualizada com sucesso!");
    }

    private PlataformaResponseDto convertToDto(Plataforma created) {
        PlataformaResponseDto plataformaResponseDto = mapper.map(created, PlataformaResponseDto.class);
        plataformaResponseDto.addLinks(created);
        return plataformaResponseDto;
    }

    private Plataforma convertToEntity(PlataformaRequestDto plataforma) {
        if(plataforma.getDeletado()){
            plataforma.setDeletado(false);
        }
        Plataforma entityPlataforma = mapper.map(plataforma, Plataforma.class);
        return entityPlataforma;
    }
}
