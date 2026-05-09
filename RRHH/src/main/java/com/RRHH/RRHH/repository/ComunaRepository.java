package com.RRHH.RRHH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Comuna;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Long> {

}
