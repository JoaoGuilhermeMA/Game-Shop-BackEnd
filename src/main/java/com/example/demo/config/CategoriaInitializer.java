package com.example.demo.config;


import com.example.demo.domain.Categoria;
import com.example.demo.domain.enums.CategoriasJogo;
import com.example.demo.service.custom.CategoriaService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class CategoriaInitializer {
    private final CategoriaService categoriaService;

    public CategoriaInitializer(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostConstruct
    public void init() {
        // Adiciona todas as categorias se não existirem
        for (CategoriasJogo categoriaEnum : CategoriasJogo.values()) {
            if (categoriaService.listAll().stream()
                    .noneMatch(categoria -> categoria.getCategoriasJogo() == categoriaEnum)) {
                Categoria categoria = new Categoria();
                categoria.setCategoriasJogo(categoriaEnum);
                categoriaService.create(categoria);
            }
        }
    }
}
