package dsw.sighierbabackend.service;

import dsw.sighierbabackend.dto.CategoriaResponseDTO;
import dsw.sighierbabackend.entity.Categoria;
import dsw.sighierbabackend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaResponseDTO> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream().map(categoria -> CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .build()).collect(Collectors.toList());
    }
}
