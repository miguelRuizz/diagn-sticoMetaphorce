package com.metaphorce.diagnostico.services;

import com.metaphorce.diagnostico.models.Sesion;
import com.metaphorce.diagnostico.models.Usuario;
import com.metaphorce.diagnostico.repositories.SesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class SesionService {
    HashMap<String,Object> datos;
    private final SesionRepository sesionRepository;
    @Autowired
    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    public List<Sesion> getSesion(){
        return this.sesionRepository.findAll();
    }

    public ResponseEntity<Object> newSesion(Sesion sesion) {
        datos = new HashMap<>();
        sesionRepository.save(sesion);
        datos.put("data",sesion);
        datos.put("message","Sesión insertada con éxito");
        return new ResponseEntity<>(
                sesion,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteSesion(Long id) {
        datos = new HashMap<>();
        boolean exists=this.sesionRepository.existsById(id);
        if(!exists){
            datos.put("error",true);
            datos.put("message","No existe una sesión con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        sesionRepository.deleteById(id);
        datos.put("message","Sesión con ID: "+id+" eliminada con éxito.");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

    public ResponseEntity<Object> updateSesion(Sesion sesion, Long id) {
        datos = new HashMap<>();
        Optional<Sesion> SesionOpcional=this.sesionRepository.findById(id);
        if(SesionOpcional.isEmpty()){
            datos.put("error",true);
            datos.put("message","No existe una sesión con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        Sesion oldSesion = SesionOpcional.get();
        //SE CAMBIAN LOS DATOS VIEJOS POR LOS NUEVOS
        oldSesion.setFecha(sesion.getFecha());
        oldSesion.setTema(sesion.getTema());
        sesionRepository.save(oldSesion);
        datos.put("message","Sesión con ID: "+id+" actualizada con éxito.");
        datos.put("data",oldSesion);
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
