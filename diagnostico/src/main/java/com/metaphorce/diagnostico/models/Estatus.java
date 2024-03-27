package com.metaphorce.diagnostico.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Estatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_estatus;
    String estatus;

    @OneToMany(targetEntity = Asistencia.class, mappedBy="estatus")
    @JsonBackReference
    private Set<Asistencia> asistencias;
}
