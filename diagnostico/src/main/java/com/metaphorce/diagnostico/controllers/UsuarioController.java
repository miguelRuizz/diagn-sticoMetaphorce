package com.metaphorce.diagnostico.controllers;
import com.metaphorce.diagnostico.models.Usuario;
import com.metaphorce.diagnostico.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/all")
    public List<Usuario> getUsuario(){
        return this.usuarioService.getUsuario();
    }
}
