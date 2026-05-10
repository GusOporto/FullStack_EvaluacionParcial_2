package com.RRHH.RRHH.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RRHH.RRHH.DTO.SucursalDTO;
import com.RRHH.RRHH.model.Colaborador;
import com.RRHH.RRHH.model.Sucursal;
import com.RRHH.RRHH.repository.SucursalRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<SucursalDTO> findAll() {
        return sucursalRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public SucursalDTO findById(Long id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada."));
        return convertirADTO(sucursal);
    }

    public SucursalDTO save(Sucursal sucursal) {
        Sucursal guardado = sucursalRepository.save(sucursal);
        return convertirADTO(guardado);
    }

    public String delete(Long id) {
        try {
            Sucursal sucursal = sucursalRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("No se pudo borrar la Sucursal ID: " + id + ", no existe."));
            sucursalRepository.delete(sucursal);
            return "La Sucursal ID: " + id + " ha sido eliminada exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public SucursalDTO updateSucursal(Long id, Sucursal sucursal1) {
        Sucursal sucursal2 = sucursalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La Sucursal no existe."));
        if (sucursal1.getNombre() != null) {
            sucursal2.setNombre(sucursal1.getNombre());
        }
        Sucursal guardado = sucursalRepository.save(sucursal2);
        return convertirADTO(guardado);
    }

    private SucursalDTO convertirADTO(Sucursal sucursal) {
        SucursalDTO dto = new SucursalDTO();
        dto.setId(sucursal.getId());
        dto.setNombre(sucursal.getNombre());
        dto.setDireccion(sucursal.getDireccion());

        if (sucursal.getRegion() != null) {
            dto.setRegion("ID: " + sucursal.getRegion().getId() + " - " + sucursal.getRegion().getNombre());
        }

        if (sucursal.getComuna() != null) {
            dto.setComuna("ID: " + sucursal.getComuna().getId() + " - " + sucursal.getComuna().getNombre());
        }

        List<String> colaboradores = new ArrayList<>();
        if (sucursal.getColaboradores() != null) {
            for (Colaborador c : sucursal.getColaboradores()) {
                colaboradores.add("ID: " + c.getId() + " - " + c.getNombres() + " " + c.getApellidos());
            }
        }
        dto.setColaboradores(colaboradores);
        return dto;
    }
}