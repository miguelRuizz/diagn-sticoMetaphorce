package com.metaphorce.diagnostico.repositories;

import com.metaphorce.diagnostico.models.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion,Long> {
}
