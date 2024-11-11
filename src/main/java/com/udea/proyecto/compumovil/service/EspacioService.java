package com.udea.proyecto.compumovil.service;

import com.udea.proyecto.compumovil.model.dto.EspacioDTO;
import com.udea.proyecto.compumovil.model.entity.Espacio;
import com.udea.proyecto.compumovil.model.mapper.EspacioMapper;
import com.udea.proyecto.compumovil.repository.EspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacioService {

    @Autowired
    private EspacioRepository espacioRepository;

    @Autowired
    private EspacioMapper espacioMapper;

    public List<EspacioDTO> listarTodos() {
        var result = espacioRepository.findAll();
        return espacioMapper.toDtoList(result);
    }

    public EspacioDTO crearEspacio(EspacioDTO espacioDTO) {
        Espacio espacio = espacioMapper.toEntity(espacioDTO);
        espacio = espacioRepository.save(espacio);
        return espacioMapper.toDto(espacio);
    }

    public EspacioDTO actualizarEspacio(EspacioDTO espacioDTO) throws RuntimeException {
        Optional<Espacio> optionalEspacio = espacioRepository.findById(espacioDTO.getId());
        if (optionalEspacio.isPresent()) {
            Espacio espacioActualizado = espacioMapper.toEntity(espacioDTO);
            espacioActualizado = espacioRepository.save(espacioActualizado);
            return espacioMapper.toDto(espacioActualizado);
        }
        throw new RuntimeException("Espacio no encontrado con ID: " + espacioDTO.getId());
    }

    public void borrarEspacio(Integer id) {
        if (espacioRepository.existsById(id)) {
            espacioRepository.deleteById(id);
        } else {
            throw new RuntimeException("Espacio no encontrado con ID: " + id);
        }
    }
}