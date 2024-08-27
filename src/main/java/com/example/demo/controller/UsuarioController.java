package com.example.demo.controller;

import com.example.demo.domain.Usuario;
import com.example.demo.dto.UsuarioRequestDto;
import com.example.demo.dto.UsuarioResponseDto;
import com.example.demo.service.custom.UsuarioService;
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
@RequestMapping("/usuarios/")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final ModelMapper mapper;

    @GetMapping
    public List<UsuarioResponseDto> listAll() {
        return service.listAll().stream().map(this::convertToDto).collect(toList());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioRequestDto usuarioDto) {
        Usuario created = service.create(convertToEntity(usuarioDto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> listById(@PathVariable("id") Long id) {
        Usuario usuario = service.listById(id);
        UsuarioResponseDto dto = convertToDto(usuario);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<UsuarioResponseDto> update(@RequestBody UsuarioRequestDto requestDto, @PathVariable("id") Long id) {
        try {
            service.listById(id);
        } catch (Exception e) {
            return create(requestDto);
        }
        Usuario usuarioUpdated = service.update(convertToEntity(requestDto));
        return ResponseEntity.ok(convertToDto(usuarioUpdated));
    }

    private UsuarioResponseDto convertToDto(Usuario usuario) {
        UsuarioResponseDto dto = mapper.map(usuario, UsuarioResponseDto.class);
        dto.addLinks(usuario);
        return dto;
    }

    private Usuario convertToEntity(UsuarioRequestDto usuarioDto) {
        return mapper.map(usuarioDto, Usuario.class);
    }
}
