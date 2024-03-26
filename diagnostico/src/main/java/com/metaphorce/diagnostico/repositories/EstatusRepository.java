package com.metaphorce.diagnostico.repositories;
import com.metaphorce.diagnostico.models.Estatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatusRepository extends JpaRepository<Estatus,Long> {
}