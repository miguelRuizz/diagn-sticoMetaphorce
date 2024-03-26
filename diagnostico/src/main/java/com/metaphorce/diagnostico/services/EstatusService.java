package com.metaphorce.diagnostico.services;

import com.metaphorce.diagnostico.models.Estatus;
import com.metaphorce.diagnostico.repositories.EstatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class EstatusService {
    HashMap<String,Object> datos;
    private final EstatusRepository estatusRepository;

    @Autowired
    public EstatusService(EstatusRepository estatusRepository) {
        this.estatusRepository = estatusRepository;
    }

    public List<Estatus> getEstatus(){
        return this.estatusRepository.findAll();
    }

    public ResponseEntity<Object> newEstatus(Estatus estatus) {
        datos = new HashMap<>();
        estatusRepository.save(estatus);
        datos.put("data",estatus);
        datos.put("message","Estatus insertado con éxito");
        return new ResponseEntity<>(
                estatus,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteEstatus(Long id) {
        datos = new HashMap<>();
        boolean exists=this.estatusRepository.existsById(id);
        if(!exists){
            datos.put("error",true);
            datos.put("message","No existe un estatus con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        estatusRepository.deleteById(id);
        datos.put("message","Estatus con ID: "+id+" eliminado con éxito.");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

    public ResponseEntity<Object> updateEstatus(Estatus estatus, Long id) {
        datos = new HashMap<>();
        Optional<Estatus> EstatusOpcional=this.estatusRepository.findById(id);
        if(EstatusOpcional.isEmpty()){
            datos.put("error",true);
            datos.put("message","No existe una estatus con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        Estatus oldEstatus = EstatusOpcional.get();
        //SE CAMBIAN LOS DATOS VIEJOS POR LOS NUEVOS
        oldEstatus.setEstatus(estatus.getEstatus());
        estatusRepository.save(oldEstatus);
        datos.put("message","Estatus con ID: "+id+" actualizado con éxito.");
        datos.put("data",oldEstatus);
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
