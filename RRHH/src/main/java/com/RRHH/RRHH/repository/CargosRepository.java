package com.RRHH.RRHH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Cargos;

@Repository
//CLASE DE REPOSITORY EN RRHH
public interface CargosRepository extends JpaRepository<Cargos, Long>{

    

}
