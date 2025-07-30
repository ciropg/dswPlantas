package dsw.sighierbabackend.dto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;

}
