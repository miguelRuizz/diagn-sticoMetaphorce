package com.metaphorce.diagnostico.models;

import java.io.Serializable;

public class AsistenciaId implements Serializable {
    private long usuario;
    private long sesion;

    public AsistenciaId() {}
    public AsistenciaId(long usuario, long sesion) {
        this.usuario = usuario;
        this.sesion = sesion;
    }
}
