package com.metaphorce.diagnostico.controllers;

import com.metaphorce.diagnostico.models.Estatus;
import com.metaphorce.diagnostico.services.EstatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estatus")
public class EstatusController {
    private final EstatusService estatusService;

    public EstatusController(EstatusService estatusService) {
        this.estatusService = estatusService;
    }

    @GetMapping("/all")
    public List<Estatus> getEstatus(){
        return this.estatusService.getEstatus();
    }

    @PostMapping
    public ResponseEntity<Object> newEstatus(@RequestBody Estatus estatus){
        return this.estatusService.newEstatus(estatus);
    }
    @PutMapping(path = "{estatusId}")
    public ResponseEntity<Object> updateEstatus(@RequestBody Estatus estatus,@PathVariable("estatusId") Long id){
        return this.estatusService.updateEstatus(estatus,id);
    }
    @DeleteMapping(path="{estatusId}")
    public ResponseEntity<Object> deleteEstatus(@PathVariable("estatusId") Long id){
        return this.estatusService.deleteEstatus(id);
    }
}
