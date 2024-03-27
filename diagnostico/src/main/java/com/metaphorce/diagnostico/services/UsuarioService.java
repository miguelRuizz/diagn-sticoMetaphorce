package com.metaphorce.diagnostico.services;

import com.metaphorce.diagnostico.models.Sesion;
import com.metaphorce.diagnostico.models.Usuario;
import com.metaphorce.diagnostico.repositories.SesionRepository;
import com.metaphorce.diagnostico.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {
    HashMap<String,Object> datos;

    @Autowired
    private final UsuarioRepository usuarioRepository;

    /*@Autowired
    private final SesionRepository sesionRepository;*/

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getUsuario(){
        return this.usuarioRepository.findAll();
    }

    public ResponseEntity<Object> newUsuario(Usuario usuario) {
        datos = new HashMap<>();
        usuarioRepository.save(usuario);
        datos.put("data",usuario);
        datos.put("message","Usuario insertado con Éxito");
        return new ResponseEntity<>(
                usuario,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> deleteUsuario(Long id) {
        datos = new HashMap<>();
        boolean exists=this.usuarioRepository.existsById(id);
        if(!exists){
            datos.put("error",true);
            datos.put("message","No existe un usuario con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        usuarioRepository.deleteById(id);
        datos.put("message","Usuario con ID: "+id+" eliminado con éxito.");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

    public ResponseEntity<Object> updateUsuario(Usuario usuario, Long id) {
        datos = new HashMap<>();
        Optional<Usuario> UsuarioOpcional=this.usuarioRepository.findById(id);
        if(UsuarioOpcional.isEmpty()){
            datos.put("error",true);
            datos.put("message","No existe un usuario con ese ID");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        Usuario oldUsuario = UsuarioOpcional.get();
        //SE CAMBIAN LOS DATOS VIEJOS POR LOS NUEVOS
        oldUsuario.setUsuario(usuario.getUsuario());
        oldUsuario.setCorreo(usuario.getCorreo());
        oldUsuario.setTelefono(usuario.getTelefono());
        oldUsuario.setContrasenia(usuario.getContrasenia());
        usuarioRepository.save(oldUsuario);
        datos.put("message","Usuario con ID: "+id+" actualizado con éxito.");
        datos.put("data",oldUsuario);
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

    /*public ResponseEntity<Object> asistenciaASesion(long usuarioId, long sesionId) {
        Set<Sesion> sesionSet = null;
        Usuario usuario = usuarioRepository.findById(usuarioId).get();
        Sesion sesion = sesionRepository.findById(sesionId).get();
        sesionSet = usuario.getSesiones();
        sesionSet.add(sesion);
        usuario.setSesiones(sesionSet);
        usuarioRepository.save(usuario);

        datos.put("message","Sesión " + sesionId + " añadida al usuario "+ usuarioId +" con éxito.");
        datos.put("data",usuario);
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }*/
}
