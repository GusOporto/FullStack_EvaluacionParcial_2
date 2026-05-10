package com.RRHH.RRHH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Evaluaciones;

@Repository
//CLASE DE EVALUACIONES EN RRHH
public interface EvaluacionesRepository extends JpaRepository<Evaluaciones,Long> {

}
