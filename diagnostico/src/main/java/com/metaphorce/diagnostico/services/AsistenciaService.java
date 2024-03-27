package com.metaphorce.diagnostico.services;

import com.metaphorce.diagnostico.models.Asistencia;
import com.metaphorce.diagnostico.models.AsistenciaId;
import com.metaphorce.diagnostico.models.Estatus;
import com.metaphorce.diagnostico.repositories.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {
    HashMap<String,Object> datos;
    private final AsistenciaRepository asistenciaRepository;

    @Autowired
    public AsistenciaService(AsistenciaRepository asistenciaRepository) {
        this.asistenciaRepository = asistenciaRepository;
    }

    public List<Asistencia> getAsistencia(){
        return this.asistenciaRepository.findAll();
    }

    public ResponseEntity<Object> newAsistencia(Asistencia asistencia) {
        datos = new HashMap<>();
        asistenciaRepository.save(asistencia);
        datos.put("data",asistencia);
        datos.put("message","Asistencia insertada con éxito");
        return new ResponseEntity<>(
                asistencia,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> updateAsistencia(Estatus estatus, AsistenciaId id) {
        datos = new HashMap<>();
        Optional<Asistencia> asistenciaOpcional=this.asistenciaRepository.findById(id);
        if(asistenciaOpcional.isEmpty()){
            datos.put("error",true);
            datos.put("message","No existe una asistencia así, con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        Asistencia oldAsistencia = asistenciaOpcional.get();
        //SE ACTUALIZAN LOS DATOS
        oldAsistencia.setEstatus(estatus);
        asistenciaRepository.save(oldAsistencia);
        datos.put("message","Asistencia con ID: "+ id +" actualizada con exito.");
        datos.put("data",oldAsistencia);
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

    public ResponseEntity<Object> deleteAsistencia(AsistenciaId id) {
        datos = new HashMap<>();
        boolean exists=this.asistenciaRepository.existsById(id);
        if(!exists){
            datos.put("error",true);
            datos.put("message","No existe una asistencia con ese ID: " + id);
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        asistenciaRepository.deleteById(id);
        datos.put("message","Asistencia con ID: "+id+" eliminada con éxito.");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
