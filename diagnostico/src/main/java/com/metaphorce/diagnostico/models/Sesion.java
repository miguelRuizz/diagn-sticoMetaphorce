package com.metaphorce.diagnostico.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sesion;
    String fecha;
    String tema;

    @OneToMany(targetEntity = Asistencia.class, mappedBy = "sesion")
    @JsonBackReference
    private Set<Asistencia> asistencias;
    /*@JsonIgnore
    @ManyToMany(mappedBy = "sesiones")
    private Set<Usuario> usuarios = new HashSet<>();*/
}
