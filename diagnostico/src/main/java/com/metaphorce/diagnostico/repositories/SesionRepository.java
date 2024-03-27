package com.metaphorce.diagnostico.repositories;

import com.metaphorce.diagnostico.models.Sesion;
import com.metaphorce.diagnostico.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion,Long> {

    @Query("SELECT a.usuario FROM Asistencia a WHERE a.sesion.id_sesion = :id_sesion AND a.estatus.id_estatus = 1")
    List<Usuario> findAsistenciaBySesionId(@Param("id_sesion") Long id_sesion);
}
