package com.metaphorce.diagnostico.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "asistencia")
@IdClass(AsistenciaId.class)
public class Asistencia {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_sesion")
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name="id_estatus", nullable=false)
    private Estatus estatus;
}
