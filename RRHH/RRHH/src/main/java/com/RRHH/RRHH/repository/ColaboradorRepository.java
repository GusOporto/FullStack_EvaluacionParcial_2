package com.RRHH.RRHH.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {

    List<Colaborador> findBySucursales(Long id);

    @Query("SELECT c FROM Colaborador c WHERE c.region.id = :regionId")
    List<Colaborador> findByRegion(@Param("regionId") Long regionId);

    @Query("SELECT c FROM Colaborador c WHERE c.comuna.id = :comunaId")
    List<Colaborador> findByComuna(@Param("comunaId") Long comunaId);

    @Query("SELECT c FROM Colaborador c WHERE c.run = :run")
    List<Colaborador> findByRun(@Param("run") String run);
}
