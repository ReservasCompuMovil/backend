package com.udea.proyecto.compumovil.controller;

import com.udea.proyecto.compumovil.model.dto.EspacioDTO;
import com.udea.proyecto.compumovil.service.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/espacio")
public class EspaciosController {

    @Autowired
    private EspacioService espacioService;

    @GetMapping
    public List<EspacioDTO> listarTodos() {
        return espacioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<EspacioDTO> crearEspacio(@RequestBody EspacioDTO espacioDTO) {
        EspacioDTO nuevoEspacio = espacioService.crearEspacio(espacioDTO);
        return ResponseEntity.ok(nuevoEspacio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EspacioDTO> actualizarEspacio(@RequestBody EspacioDTO espacioDTO) {
        try {
            EspacioDTO espacioActualizado = espacioService.actualizarEspacio(espacioDTO);
            return ResponseEntity.ok(espacioActualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarEspacio(@PathVariable Integer id) {
        try {
            espacioService.borrarEspacio(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}