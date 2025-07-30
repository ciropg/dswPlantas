package dsw.sighierbabackend.dto;

import lombok.*;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HierbaRequestDTO {
    private String nombreComun;
    private String nombreCientifico;
    private String descripcion;
    private String propiedades;
    private String usos;
    private Long categoriaId; // solo enviamos el ID de la categoría
}
