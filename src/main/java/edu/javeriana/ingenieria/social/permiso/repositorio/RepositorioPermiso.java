package edu.javeriana.ingenieria.social.permiso.repositorio;

import edu.javeriana.ingenieria.social.permiso.dominio.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPermiso extends JpaRepository<Permiso, Integer> {
    Permiso findOneByDescripcion(String descripcion);

    Permiso findOneByCodigo(Integer codigo);

    boolean existsByCodigo(Integer codigo);

    boolean existsByDescripcion(String descripcion);
}
