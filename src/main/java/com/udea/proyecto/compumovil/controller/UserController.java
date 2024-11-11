package com.udea.proyecto.compumovil.controller;

import com.udea.proyecto.compumovil.model.dto.UsuarioDTO;
import com.udea.proyecto.compumovil.model.enums.RoleEnum;
import com.udea.proyecto.compumovil.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodosLosUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.listarTodosLosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Obtener usuarios por rol específico
    @GetMapping("/rol/{rol}")
    public ResponseEntity<List<UsuarioDTO>> listarUsuariosPorRol(@PathVariable RoleEnum rol) {
        List<UsuarioDTO> usuarios = usuarioService.listarUsuariosPorRol(rol);
        return ResponseEntity.ok(usuarios);
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioPorId(@PathVariable Integer id) {
        usuarioService.eliminarUsuarioPorId(id);
        return ResponseEntity.noContent().build();
    }
}