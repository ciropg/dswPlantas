package dsw.sighierbabackend.service;

import dsw.sighierbabackend.dto.UsuarioLoginRequestDTO;
import dsw.sighierbabackend.dto.UsuarioRequestDTO;
import dsw.sighierbabackend.dto.UsuarioResponseDTO;
import dsw.sighierbabackend.entity.Rol;
import dsw.sighierbabackend.entity.Usuario;
import dsw.sighierbabackend.repository.RolRepository;
import dsw.sighierbabackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO registrarUsuario(UsuarioRequestDTO dto) {
        // Validar si existe correo
        Optional<Usuario> existente = usuarioRepository.findByCorreo(dto.getCorreo());
        if (existente.isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // Obtener rol
        Rol rol = rolRepository.findById(dto.getIdRol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        // Encriptar la contraseña
        String contrasenaEncriptada = passwordEncoder.encode(dto.getContrasena());

        // Crear entidad Usuario
        Usuario nuevoUsuario = Usuario.builder()
                .nombreUsuario(dto.getNombreUsuario())
                .correo(dto.getCorreo())
                .contrasena(contrasenaEncriptada)
                .rol(rol)
                .build();

        Usuario guardado = usuarioRepository.save(nuevoUsuario);

        return UsuarioResponseDTO.builder()
                .id(guardado.getId())
                .nombreUsuario(guardado.getNombreUsuario())
                .correo(guardado.getCorreo())
                .rol(guardado.getRol().getNombre())
                .build();
    }
    public UsuarioResponseDTO login(UsuarioLoginRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByCorreo(dto.getCorreo())
                .orElseThrow(() -> new RuntimeException("Correo no registrado"));

        if (!passwordEncoder.matches(dto.getContrasena(), usuario.getContrasena())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return UsuarioResponseDTO.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .correo(usuario.getCorreo())
                .rol(usuario.getRol().getNombre())
                .build();
    }

}
