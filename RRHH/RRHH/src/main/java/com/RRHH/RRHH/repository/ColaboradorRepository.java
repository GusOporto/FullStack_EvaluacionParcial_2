package com.RRHH.RRHH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{

}
