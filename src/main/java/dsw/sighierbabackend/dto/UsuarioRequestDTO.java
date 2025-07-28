package dsw.sighierbabackend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private Long id;
    private String nombreUsuario;
    private String correo;
    private String contrasena;
    private Long idRol;

}
