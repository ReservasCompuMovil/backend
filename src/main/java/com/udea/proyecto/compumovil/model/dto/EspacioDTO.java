package com.udea.proyecto.compumovil.model.dto;

import lombok.Data;

@Data
public class EspacioDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer capacidad;
    private String ubicacion;
    private String deporte;
    private Boolean activo;
}