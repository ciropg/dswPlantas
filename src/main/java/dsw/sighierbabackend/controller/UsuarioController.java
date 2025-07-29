package dsw.sighierbabackend.controller;

import dsw.sighierbabackend.dto.UsuarioLoginRequestDTO;
import dsw.sighierbabackend.dto.UsuarioRequestDTO;
import dsw.sighierbabackend.dto.UsuarioResponseDTO;
import dsw.sighierbabackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public UsuarioResponseDTO registrar(@RequestBody UsuarioRequestDTO dto) {
        return usuarioService.registrarUsuario(dto);
    }
    @PostMapping("/login")
    public UsuarioResponseDTO login(@RequestBody UsuarioLoginRequestDTO dto) {
        return usuarioService.login(dto);
    }


}
