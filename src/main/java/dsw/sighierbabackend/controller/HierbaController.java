package dsw.sighierbabackend.controller;

import dsw.sighierbabackend.dto.HierbaRequestDTO;
import dsw.sighierbabackend.dto.HierbaResponseDTO;
import dsw.sighierbabackend.service.HierbaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hierbas")
public class HierbaController {
    @Autowired
    private HierbaService hierbaService;

    @PostMapping
    public HierbaResponseDTO registrar(@RequestBody HierbaRequestDTO dto) {
        return hierbaService.registrarHierba(dto);
    }
    @GetMapping
    public List<HierbaResponseDTO> listarHierbas() {
        return hierbaService.listarHierbas();
    }
}
