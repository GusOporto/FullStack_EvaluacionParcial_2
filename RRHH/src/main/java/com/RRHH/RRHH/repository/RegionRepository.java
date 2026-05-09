package com.RRHH.RRHH.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RRHH.RRHH.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
