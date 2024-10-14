package com.udea.proyecto.compumovil.repository;

import com.udea.proyecto.compumovil.model.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

    Usuario findByCorreo(String correo);
}
