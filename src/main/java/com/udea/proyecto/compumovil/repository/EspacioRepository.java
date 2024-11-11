package com.udea.proyecto.compumovil.repository;

import com.udea.proyecto.compumovil.model.entity.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Integer> {
}