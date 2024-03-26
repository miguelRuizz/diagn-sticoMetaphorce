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
public class Estatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_estatus;
    String estatus;
}
