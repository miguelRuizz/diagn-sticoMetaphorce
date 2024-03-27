package com.metaphorce.diagnostico.controllers;

import com.metaphorce.diagnostico.models.Asistencia;
import com.metaphorce.diagnostico.models.AsistenciaId;
import com.metaphorce.diagnostico.models.Estatus;
import com.metaphorce.diagnostico.services.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/asistencia")
public class AsistenciaController {
    private final AsistenciaService asistenciaService;

    @Autowired
    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @GetMapping("/all")
    public List<Asistencia> getAsistencia(){
        return this.asistenciaService.getAsistencia();
    }

    @PostMapping
    public ResponseEntity<Object> newAsistencia(@RequestBody Asistencia asistencia){
        return this.asistenciaService.newAsistencia(asistencia);
    }

    @PutMapping("/{usuarioId}/{sesionId}")
    public ResponseEntity<Object> updateAsistencia(@RequestBody Estatus estatus,
                                                      @PathVariable("usuarioId")Long usuarioId,
                                                      @PathVariable("sesionId") Long sesionId){
        AsistenciaId id = new AsistenciaId(usuarioId, sesionId);
        return this.asistenciaService.updateAsistencia(estatus,id);
    }

    @DeleteMapping("/{usuarioId}/{idSesion}")
    public ResponseEntity<Object> deleteAsistencia(@PathVariable("usuarioId")Long idUsuario,
                                                      @PathVariable("idSesion") Long idSesion){
        AsistenciaId id = new AsistenciaId(idUsuario, idSesion);
        return this.asistenciaService.deleteAsistencia(id);
    }
}
