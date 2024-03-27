package com.metaphorce.diagnostico.controllers;

import com.metaphorce.diagnostico.models.Sesion;
import com.metaphorce.diagnostico.services.SesionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sesion")
public class SesionController {
    private final SesionService sesionService;

    public SesionController(SesionService sesionService) {
        this.sesionService = sesionService;
    }

    @GetMapping("/all")
    public List<Sesion> getSesion(){
        return this.sesionService.getSesion();
    }

    @PostMapping
    public ResponseEntity<Object> newSesion(@RequestBody Sesion sesion){
        return this.sesionService.newSesion(sesion);
    }
    @PutMapping(path = "{sesionId}")
    public ResponseEntity<Object> updateSesion(@RequestBody Sesion sesion,@PathVariable("sesionId") Long id){
        return this.sesionService.updateSesion(sesion,id);
    }
    @DeleteMapping(path="{sesionId}")
    public ResponseEntity<Object> deleteSesion(@PathVariable("sesionId") Long id){
        return this.sesionService.deleteSesion(id);
    }
    @GetMapping("/{sesionId}/asistencias")
    public ResponseEntity<Object> getAsistencias(@PathVariable("sesionId") Long id){
        return this.sesionService.getAsistencias(id);
    }
}
