package com.udea.proyecto.compumovil.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    @Column(name = "espacio_id", nullable = false)
    private Integer espacioId;

    @Column(name = "fecha_reserva", nullable = false)
    private java.time.LocalDate fechaReserva;

    @Column(name = "hora_inicio", nullable = false)
    private java.time.LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private java.time.LocalTime horaFin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "estado")
    private EstadoReserva estado = EstadoReserva.ACTIVA;

    public enum EstadoReserva {
       ACTIVA, CANCELADA
    }
}