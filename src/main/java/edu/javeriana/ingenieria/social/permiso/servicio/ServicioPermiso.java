package edu.javeriana.ingenieria.social.permiso.servicio;

import edu.javeriana.ingenieria.social.permiso.dominio.Permiso;
import edu.javeriana.ingenieria.social.permiso.repositorio.RepositorioPermiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPermiso {
    @Autowired
    private RepositorioPermiso repositorio;

    public List<Permiso> obtenerPermisos(){
        return repositorio.findAll();
    }

    public Permiso obtenerPermiso(Integer codigo){
        return repositorio.findOneByCodigo(codigo);
    }

    public Permiso obtenerPermiso(String descripcion){
        return repositorio.findOneByDescripcion(descripcion);
    }

    public boolean permisoExiste(Integer codigo){
        return repositorio.existsByCodigo(codigo);
    }

    public boolean permisoExiste(String descripcion){
        return repositorio.existsByDescripcion(descripcion);
    }
}
