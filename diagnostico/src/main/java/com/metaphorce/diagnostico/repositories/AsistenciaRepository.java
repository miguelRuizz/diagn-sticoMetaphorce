package com.metaphorce.diagnostico.repositories;

import com.metaphorce.diagnostico.models.Asistencia;
import com.metaphorce.diagnostico.models.AsistenciaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, AsistenciaId> {
}
