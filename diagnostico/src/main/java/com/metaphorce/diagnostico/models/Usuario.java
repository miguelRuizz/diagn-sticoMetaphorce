package com.metaphorce.diagnostico.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;
    private String usuario;
    private String correo;
    private String telefono;
    private String contrasenia;

    @OneToMany(targetEntity = Asistencia.class, mappedBy = "usuario")
    @JsonBackReference
    private Set<Asistencia> asistencias;
    /*@ManyToMany
    @JoinTable(name = "asistencia",
            joinColumns = {@JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")},
            inverseJoinColumns = {@JoinColumn(name = "id_sesion",referencedColumnName = "id_sesion")}
    )
    private Set<Sesion> sesiones = new HashSet<>();*/
}
