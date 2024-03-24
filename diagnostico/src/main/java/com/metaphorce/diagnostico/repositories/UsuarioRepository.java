package com.metaphorce.diagnostico.repositories;

import com.metaphorce.diagnostico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}