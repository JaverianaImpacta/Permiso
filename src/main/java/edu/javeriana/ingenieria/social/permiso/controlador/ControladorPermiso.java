package edu.javeriana.ingenieria.social.permiso.controlador;

import edu.javeriana.ingenieria.social.permiso.dominio.Permiso;
import edu.javeriana.ingenieria.social.permiso.servicio.ServicioPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
@CrossOrigin(origins="http://localhost:4200")
public class ControladorPermiso{
    @Autowired
    private ServicioPermiso servicio;

    @GetMapping("listar")
    public List<Permiso> obtenerPermisos(){
        return servicio.obtenerPermisos();
    }

    @GetMapping("obtener")
    public ResponseEntity<Permiso> obtenerPermiso(@RequestParam Integer codigo){
        if(codigo == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.permisoExiste(codigo)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerPermiso(codigo), HttpStatus.OK);
    }

    @GetMapping("obtenerDescripcion")
    public ResponseEntity<Permiso> obtenerPermiso(@RequestParam String descripcion){
        if(descripcion == null || descripcion.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!servicio.permisoExiste(descripcion)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(servicio.obtenerPermiso(descripcion), HttpStatus.OK);
    }
}
