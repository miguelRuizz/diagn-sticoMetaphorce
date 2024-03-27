package com.metaphorce.diagnostico.repositories;

import com.metaphorce.diagnostico.models.Sesion;
import com.metaphorce.diagnostico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query("SELECT a.sesion FROM Asistencia a WHERE a.usuario.id_usuario = :id_usuario AND a.estatus.id_estatus = 1")
    List<Sesion> findAsistenciaByUsuarioId(@Param("id_usuario") Long id_usuario);

}