package com.udea.proyecto.compumovil.model.mapper;

import com.udea.proyecto.compumovil.model.dto.ReservaDTO;
import com.udea.proyecto.compumovil.model.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "usuarioId", source = "usuarioId")
    @Mapping(target = "espacioId", source = "espacioId")
    @Mapping(target = "fechaReserva", source = "fechaReserva")
    @Mapping(target = "horaInicio", source = "horaInicio")
    @Mapping(target = "horaFin", source = "horaFin")
    @Mapping(target = "estado", source = "estado")
    Reserva toEntity(ReservaDTO reservaDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "usuarioId", source = "usuarioId")
    @Mapping(target = "espacioId", source = "espacioId")
    @Mapping(target = "fechaReserva", source = "fechaReserva")
    @Mapping(target = "horaInicio", source = "horaInicio")
    @Mapping(target = "horaFin", source = "horaFin")
    @Mapping(target = "estado", source = "estado")
    ReservaDTO toDto(Reserva reserva);

    List<ReservaDTO> toDtoList(List<Reserva> reservas);

    List<Reserva> toEntityList(List<ReservaDTO> reservaDTOs);
}