package com.udea.proyecto.compumovil.model.mapper;

import com.udea.proyecto.compumovil.model.dto.ReservaDTO;
import com.udea.proyecto.compumovil.model.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    @Mapping(target = "usuarioId", source = "usuario.id")
    @Mapping(target = "usuarioNombre", source = "usuario.nombre")
    @Mapping(target = "espacioId", source = "espacio.id")
    @Mapping(target = "espacioNombre", source = "espacio.nombre")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fechaReserva", source = "fechaReserva")
    @Mapping(target = "horaInicio", source = "horaInicio")
    @Mapping(target = "horaFin", source = "horaFin")
    @Mapping(target = "estado", source = "estado")
    ReservaDTO toDto(Reserva reserva);

    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "espacio.id", source = "espacioId")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "fechaReserva", source = "fechaReserva")
    @Mapping(target = "horaInicio", source = "horaInicio")
    @Mapping(target = "horaFin", source = "horaFin")
    @Mapping(target = "estado", source = "estado")
    Reserva toEntity(ReservaDTO reservaDTO);


    List<ReservaDTO> toDtoList(List<Reserva> reservas);

    List<Reserva> toEntityList(List<ReservaDTO> reservaDTOs);
}