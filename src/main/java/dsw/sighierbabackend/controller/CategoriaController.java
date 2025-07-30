package dsw.sighierbabackend.controller;

import dsw.sighierbabackend.dto.CategoriaResponseDTO;
import dsw.sighierbabackend.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaResponseDTO> listarCategorias() {
        return categoriaService.listarCategorias();
    }
}
