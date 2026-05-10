package com.RRHH.RRHH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Curriculum;

@Repository
//CLASE DE CURRICULUM EN RRHH
public interface CurriculumRepository extends JpaRepository<Curriculum,Long>{

}
