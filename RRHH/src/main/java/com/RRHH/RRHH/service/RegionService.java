package com.RRHH.RRHH.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RRHH.RRHH.DTO.RegionDTO;
import com.RRHH.RRHH.model.Colaborador;
import com.RRHH.RRHH.model.Comuna;
import com.RRHH.RRHH.model.Region;
import com.RRHH.RRHH.model.Sucursal;
import com.RRHH.RRHH.repository.RegionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<RegionDTO> findAll() {
        return regionRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public RegionDTO findById(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Region no encontrada."));
        return convertirADTO(region);
    }

    public Region save(Region region) {
        return regionRepository.save(region);
    }

    public String delete(Long id) {
        try {
            Region region = regionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se pudo borrar la Region ID: " + id + ", no existe."));
            regionRepository.delete(region);
            return "La Region ID: " + id + " ha sido eliminada exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public RegionDTO updateRegion(Long id, Region region1) {
        Region region2 = regionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La Region no existe."));
        if (region1.getNombre() != null) {
            region2.setNombre(region1.getNombre());
        }
        return convertirADTO(regionRepository.save(region2));
    }

    private RegionDTO convertirADTO(Region region) {
        RegionDTO dto = new RegionDTO();
        dto.setId(region.getId());
        dto.setNombre(region.getNombre());

        List<String> comunas = new ArrayList<>();
        if (region.getComunas() != null) {
            for (Comuna c : region.getComunas()) {
                comunas.add(c.getNombre());
            }
        }
        dto.setComunas(comunas);

        List<String> sucursales = new ArrayList<>();
        if (region.getSucursales() != null) {
            for (Sucursal s : region.getSucursales()) {
                sucursales.add(s.getNombre());
            }
        }
        dto.setSucursales(sucursales);

        List<String> colaboradores = new ArrayList<>();
        if (region.getColaboradores() != null) {
            for (Colaborador c : region.getColaboradores()) {
                colaboradores.add("ID: " + c.getId() + " - " + c.getNombres() + " " + c.getApellidos());
            }
        }
        dto.setColaboradores(colaboradores);
        return dto;
    }
}
