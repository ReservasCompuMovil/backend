package com.udea.proyecto.compumovil.repository;

import com.udea.proyecto.compumovil.model.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findByEspacioIdAndFechaReserva(Integer espacioId, LocalDate fechaReserva);
    List<Reserva> findByUsuarioId(Integer usuarioId);
}