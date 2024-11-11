package com.udea.proyecto.compumovil.repository;

import com.udea.proyecto.compumovil.model.entity.Usuario;
import com.udea.proyecto.compumovil.model.enums.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

    Usuario findByCorreo(String correo);

    List<Usuario> findByRol(RoleEnum rol);
}
