package dsw.sighierbabackend.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioLoginRequestDTO {
    private String correo;
    private String contrasena;
}
