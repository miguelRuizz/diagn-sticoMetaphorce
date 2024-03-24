package com.metaphorce.diagnostico.services;

import com.metaphorce.diagnostico.models.Usuario;
import com.metaphorce.diagnostico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UsuarioService {
    HashMap<String,Object> datos;

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuario(){
        return this.usuarioRepository.findAll();
    }
}
