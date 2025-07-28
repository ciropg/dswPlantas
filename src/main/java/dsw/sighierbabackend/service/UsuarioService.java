package dsw.sighierbabackend.service;

import dsw.sighierbabackend.repository.RolRepository;
import dsw.sighierbabackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;



}
