package com.udea.proyecto.compumovil.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espacio")
@Data
@NoArgsConstructor
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "ubicacion", length = 100)
    private String ubicacion;

    @Column(name = "deporte", length = 100)
    private String deporte;

    @Column(name = "activo", nullable = false)
    private Boolean activo = true;
}