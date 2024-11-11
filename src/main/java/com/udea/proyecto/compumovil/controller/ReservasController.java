package com.udea.proyecto.compumovil.controller;

import com.udea.proyecto.compumovil.model.dto.ReservaDTO;
import com.udea.proyecto.compumovil.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservasController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Object> crearReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            ReservaDTO nuevaReserva = reservaService.crearReserva(reservaDTO);
            return ResponseEntity.ok(nuevaReserva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/espacio/{espacioId}/fecha/{fechaReserva}")
    public ResponseEntity<Object> reservasDeEspacioEnDiaEspecifico(
            @PathVariable Integer espacioId, @PathVariable LocalDate fechaReserva) {
        try {
            List<ReservaDTO> reservas = reservaService.reservasDeEspacioEnDiaEspecifico(espacioId, fechaReserva);
            return ResponseEntity.ok(reservas);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReservaDTO>> reservasDeUsuarioEspecifico(@PathVariable Integer usuarioId) {
        List<ReservaDTO> reservas = reservaService.reservasDeUsuarioEspecifico(usuarioId);
        return ResponseEntity.ok(reservas);
    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Integer id) {
        try {
            reservaService.cancelarReserva(id);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> listarTodas() {
        List<ReservaDTO> reservas = reservaService.listarTodas();
        return ResponseEntity.ok(reservas);
    }
}