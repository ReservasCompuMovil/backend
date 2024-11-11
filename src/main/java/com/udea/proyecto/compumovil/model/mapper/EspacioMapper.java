package com.udea.proyecto.compumovil.model.mapper;

import com.udea.proyecto.compumovil.model.dto.EspacioDTO;
import com.udea.proyecto.compumovil.model.entity.Espacio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EspacioMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "capacidad", source = "capacidad")
    @Mapping(target = "ubicacion", source = "ubicacion")
    @Mapping(target = "deporte", source = "deporte")
    @Mapping(target = "activo", source = "activo")
    Espacio toEntity(EspacioDTO espacioDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "descripcion", source = "descripcion")
    @Mapping(target = "capacidad", source = "capacidad")
    @Mapping(target = "ubicacion", source = "ubicacion")
    @Mapping(target = "deporte", source = "deporte")
    @Mapping(target = "activo", source = "activo")
    EspacioDTO toDto(Espacio espacio);

    List<EspacioDTO> toDtoList(List<Espacio> espacios);

    List<Espacio> toEntityList(List<EspacioDTO> espaciosDTO);

}