package dsw.sighierbabackend.dto;
import dsw.sighierbabackend.entity.Categoria;
import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HierbaResponseDTO {
    private Long id;
    private String nombreComun;
    private String nombreCientifico;
    private String descripcion;
    private String propiedades;
    private String usos;
    private LocalDateTime fechaRegistro;
    private Categoria categoria; // incluye el objeto completo
}
