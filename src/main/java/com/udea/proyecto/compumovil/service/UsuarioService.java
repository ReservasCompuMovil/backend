package com.udea.proyecto.compumovil.service;

import com.udea.proyecto.compumovil.model.dto.UsuarioDTO;
import com.udea.proyecto.compumovil.model.entity.Usuario;
import com.udea.proyecto.compumovil.model.enums.RoleEnum;
import com.udea.proyecto.compumovil.model.mapper.UsuarioMapper;
import com.udea.proyecto.compumovil.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    // Obtener todos los usuarios
    public List<UsuarioDTO> listarTodosLosUsuarios() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        //quitar contraseña de cada usuario coon Stream
        return usuarios.stream()
                .map(usuario -> {
                    usuario.setContrasena(null);  // Quitar la contraseña
                    return usuarioMapper.toUsuarioDTO(usuario); // Convertir a DTO
                })
                .collect(Collectors.toList());

    }

    // Obtener usuarios por rol específico
    public List<UsuarioDTO> listarUsuariosPorRol(RoleEnum rol) {
        System.out.println(rol);
        List<Usuario> usuarios = usuarioRepository.findByRol(rol);
        System.out.println(usuarios);
        return usuarios.stream()
                .map(usuario -> {
                    usuario.setContrasena(null);  // Quitar la contraseña
                    return usuarioMapper.toUsuarioDTO(usuario); // Convertir a DTO
                })
                .collect(Collectors.toList());

    }

    // Eliminar un usuario por ID
    public void eliminarUsuarioPorId(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
    }
}