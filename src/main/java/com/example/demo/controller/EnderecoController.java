package com.example.demo.controller;

import com.example.demo.domain.Endereco;
import com.example.demo.dto.EnderecoRequestDto;
import com.example.demo.dto.EnderecoResponseDto;
import com.example.demo.service.custom.EnderecoService;
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
@RequestMapping("/enderecos/")
@AllArgsConstructor
public class EnderecoController {

    EnderecoService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<EnderecoResponseDto> listAll(){
        return service.listAll().stream().map(this::convertToDto).collect(toList());
    }

    @PostMapping
    public ResponseEntity<EnderecoResponseDto> create(@RequestBody EnderecoRequestDto endereco) {

        Endereco created = service.create(convertToEntity(endereco));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<EnderecoResponseDto> listById(@PathVariable("id") Long id) {

        Endereco e = service.listById(id);
        EnderecoResponseDto dto = mapper.map(e, EnderecoResponseDto.class);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<EnderecoResponseDto> update(@RequestBody EnderecoRequestDto requestDto, @PathVariable("id") Long id) {

        try {
            Endereco e = service.listById(id);
        } catch (Exception e) {
            return this.create(requestDto);
        }

        Endereco EnderecoUpdated = service.update(mapper.map(requestDto, Endereco.class), id);
        return ResponseEntity.ok(convertToDto(EnderecoUpdated));
    }

    private EnderecoResponseDto convertToDto(Endereco created) {
        EnderecoResponseDto enderecoResponseDto = mapper.map(created, EnderecoResponseDto.class);
        enderecoResponseDto.addLinks(created);
        return enderecoResponseDto;
    }

    private Endereco convertToEntity(EnderecoRequestDto endereco) {
        Endereco entityEndereco = mapper.map(endereco, Endereco.class);
        return entityEndereco;
    }
}
