package com.metaphorce.diagnostico.models;

import jakarta.persistence.*;
import lombok.*;

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
}
