package com.udea.proyecto.compumovil.model.dto;

import lombok.Data;

@Data
public class ReservaDTO {
    private Integer id;
    private Integer usuarioId;
    private Integer espacioId;
    private java.time.LocalDate fechaReserva;
    private java.time.LocalTime horaInicio;
    private java.time.LocalTime horaFin;
    private String estado; // Puede ser ACTIVA o CANCELADA
}