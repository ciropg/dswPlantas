package dsw.sighierbabackend.service;
import dsw.sighierbabackend.dto.HierbaRequestDTO;
import dsw.sighierbabackend.dto.HierbaResponseDTO;
import dsw.sighierbabackend.entity.Categoria;
import dsw.sighierbabackend.entity.Hierba;
import dsw.sighierbabackend.repository.CategoriaRepository;
import dsw.sighierbabackend.repository.HierbaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HierbaService {
    @Autowired
    private HierbaRepository hierbaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public HierbaResponseDTO registrarHierba(HierbaRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Hierba hierba = Hierba.builder()
                .nombreComun(dto.getNombreComun())
                .nombreCientifico(dto.getNombreCientifico())
                .descripcion(dto.getDescripcion())
                .propiedades(dto.getPropiedades())
                .usos(dto.getUsos())
                .categoria(categoria)
                .build();

        Hierba hierbaGuardada = hierbaRepository.save(hierba);

        return HierbaResponseDTO.builder()
                .id(hierbaGuardada.getId())
                .nombreComun(hierbaGuardada.getNombreComun())
                .nombreCientifico(hierbaGuardada.getNombreCientifico())
                .descripcion(hierbaGuardada.getDescripcion())
                .propiedades(hierbaGuardada.getPropiedades())
                .usos(hierbaGuardada.getUsos())
                .fechaRegistro(hierbaGuardada.getFechaRegistro())
                .categoria(hierbaGuardada.getCategoria())
                .build();
    }
    public List<HierbaResponseDTO> listarHierbas() {
        List<Hierba> hierbas = hierbaRepository.findAll();

        return hierbas.stream().map(hierba -> HierbaResponseDTO.builder()
                .id(hierba.getId())
                .nombreComun(hierba.getNombreComun())
                .nombreCientifico(hierba.getNombreCientifico())
                .descripcion(hierba.getDescripcion())
                .propiedades(hierba.getPropiedades())
                .usos(hierba.getUsos())
                .fechaRegistro(hierba.getFechaRegistro())
                .categoria(hierba.getCategoria()) // Incluye objeto categoría completo
                .build()
        ).collect(Collectors.toList());
    }
    public void eliminarHierba(Long id) {
        if (!hierbaRepository.existsById(id)) {
            throw new RuntimeException("Hierba no encontrada con ID: " + id);
        }
        hierbaRepository.deleteById(id);
    }
    public HierbaResponseDTO actualizarHierba(Long id, HierbaRequestDTO dto) {
        Hierba hierbaExistente = hierbaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hierba no encontrada con ID: " + id));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        hierbaExistente.setNombreComun(dto.getNombreComun());
        hierbaExistente.setNombreCientifico(dto.getNombreCientifico());
        hierbaExistente.setDescripcion(dto.getDescripcion());
        hierbaExistente.setPropiedades(dto.getPropiedades());
        hierbaExistente.setUsos(dto.getUsos());
        hierbaExistente.setCategoria(categoria);

        Hierba hierbaActualizada = hierbaRepository.save(hierbaExistente);

        return HierbaResponseDTO.builder()
                .id(hierbaActualizada.getId())
                .nombreComun(hierbaActualizada.getNombreComun())
                .nombreCientifico(hierbaActualizada.getNombreCientifico())
                .descripcion(hierbaActualizada.getDescripcion())
                .propiedades(hierbaActualizada.getPropiedades())
                .usos(hierbaActualizada.getUsos())
                .fechaRegistro(hierbaActualizada.getFechaRegistro())
                .categoria(hierbaActualizada.getCategoria())
                .build();
    }

}
