package com.udea.proyecto.compumovil.service;
import com.udea.proyecto.compumovil.model.dto.ReservaDTO;
import com.udea.proyecto.compumovil.model.entity.Espacio;
import com.udea.proyecto.compumovil.model.entity.Reserva;
import com.udea.proyecto.compumovil.model.mapper.ReservaMapper;
import com.udea.proyecto.compumovil.repository.EspacioRepository;
import com.udea.proyecto.compumovil.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private EspacioRepository espacioRepository;

    @Autowired
    private ReservaMapper reservaMapper;

    public ReservaDTO crearReserva(ReservaDTO reservaDTO) {
        reservaDTO.setEstado(Reserva.EstadoReserva.ACTIVA.toString());
        List<Reserva> reservasExistentes = reservaRepository.findByEspacioIdAndFechaReserva(
                reservaDTO.getEspacioId(), reservaDTO.getFechaReserva());

        for (Reserva reserva : reservasExistentes) {
            if (reservaDTO.getHoraInicio().isBefore(reserva.getHoraFin()) &&
                    reservaDTO.getHoraFin().isAfter(reserva.getHoraInicio()) && reserva.getEstado() == Reserva.EstadoReserva.ACTIVA
            ) {
                throw new RuntimeException("La reserva se solapa con una existente.");
            }
        }

        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        reserva = reservaRepository.save(reserva);
        return reservaMapper.toDto(reserva);
    }

    public List<ReservaDTO> reservasDeEspacioEnDiaEspecifico(Integer espacioId, LocalDate fechaReserva) {
        Optional< Espacio > EspacioOptional = espacioRepository.findById(espacioId);
        if (!EspacioOptional.isPresent()) {
            throw new RuntimeException("Reserva no encontrada con ID: " + espacioId);
        }
        List<Reserva> reservas = reservaRepository.findByEspacioIdAndFechaReserva(espacioId, fechaReserva);
        System.out.println();
        return reservaMapper.toDtoList(reservas);
    }

    public List<ReservaDTO> reservasDeUsuarioEspecifico(Integer usuarioId) {
        List<Reserva> reservas = reservaRepository.findByUsuarioId(usuarioId);
        return reservaMapper.toDtoList(reservas);
    }

    public void cancelarReserva(Integer id) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            Reserva reserva = optionalReserva.get();
            reserva.setEstado(Reserva.EstadoReserva.CANCELADA);
            reservaRepository.save(reserva);
        } else {
            throw new RuntimeException("Reserva no encontrada con ID: " + id);
        }
    }

    public List<ReservaDTO> listarTodas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservaMapper.toDtoList(reservas);
    }
}
