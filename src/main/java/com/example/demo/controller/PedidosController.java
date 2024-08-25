package com.example.demo.controller;

import com.example.demo.domain.Jogo;
import com.example.demo.domain.Pedidos;
import com.example.demo.domain.Usuario;
import com.example.demo.dto.PedidosRequestDto;
import com.example.demo.dto.PedidosResponseDto;
import com.example.demo.service.custom.JogoService;
import com.example.demo.service.custom.PedidosService;
import com.example.demo.service.custom.UsuarioService;
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
@RequestMapping("/pedidos/")
@AllArgsConstructor
public class PedidosController {

    private final PedidosService service;
    private final JogoService jogoService;
    private final UsuarioService usuarioService;
    private final ModelMapper mapper;

    @GetMapping
    public List<PedidosResponseDto> listAll() {
        return service.listAll().stream().map(this::convertToDto).collect(toList());
    }

    @PostMapping
    public ResponseEntity<PedidosResponseDto> create(@RequestBody PedidosRequestDto pedidosDto) {
        Pedidos created = service.create(convertToEntity(pedidosDto));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(convertToDto(created));
    }

    @GetMapping("{id}")
    public ResponseEntity<PedidosResponseDto> listById(@PathVariable("id") Long id) {
        Pedidos pedidos = service.listById(id);
        PedidosResponseDto dto = convertToDto(pedidos);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<PedidosResponseDto> update(@RequestBody PedidosRequestDto requestDto, @PathVariable("id") Long id) {
        try {
            service.listById(id);
        } catch (Exception e) {
            return create(requestDto);
        }
        Pedidos pedidosUpdated = service.update(convertToEntity(requestDto), id);
        return ResponseEntity.ok(convertToDto(pedidosUpdated));
    }

    private PedidosResponseDto convertToDto(Pedidos pedidos) {
        PedidosResponseDto dto = mapper.map(pedidos, PedidosResponseDto.class);
        dto.addLinks(pedidos);
        return dto;
    }

    private Pedidos convertToEntity(PedidosRequestDto pedidosDto) {
        Pedidos pedidos = mapper.map(pedidosDto, Pedidos.class);

        List<Jogo> jogos = pedidosDto.getJogos().stream()
                .map(id -> jogoService.listById(id))
                .collect(Collectors.toList());
        pedidos.setJogos(jogos);

        Usuario usuario = usuarioService.listById(pedidosDto.getUsuario());
        pedidos.setUsuario(usuario);

        return pedidos;
    }
}
