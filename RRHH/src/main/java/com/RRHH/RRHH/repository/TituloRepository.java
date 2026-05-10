package com.RRHH.RRHH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Titulo;

@Repository
//CLASE DE TITULO EN RRHH
public interface TituloRepository extends JpaRepository<Titulo,Long>{

}
