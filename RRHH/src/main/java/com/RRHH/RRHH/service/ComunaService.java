package com.RRHH.RRHH.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RRHH.RRHH.DTO.ComunaDTO;
import com.RRHH.RRHH.model.Colaborador;
import com.RRHH.RRHH.model.Comuna;
import com.RRHH.RRHH.model.Sucursal;
import com.RRHH.RRHH.repository.ComunaRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ComunaService {

    @Autowired
    private ComunaRepository comunaRepository;

    public List<ComunaDTO> findAll() {
        return comunaRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ComunaDTO findById(Long id) {
        Comuna comuna = comunaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comuna no encontrada."));
        return convertirADTO(comuna);
    }

    public Comuna save(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public String delete(Long id) {
        try {
            Comuna comuna = comunaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("No se pudo borrar la Comuna ID: " + id + ", no existe."));
            comunaRepository.delete(comuna);
            return "La Comuna ID: " + id + " ha sido eliminada exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Comuna updateComuna(Long id, Comuna comuna1) {
        Comuna comuna2 = comunaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La Comuna no existe."));
        if (comuna1.getNombre() != null) {
            comuna2.setNombre(comuna1.getNombre());
        }
        return comunaRepository.save(comuna2);
    }

    private ComunaDTO convertirADTO(Comuna comuna) {
        ComunaDTO dto = new ComunaDTO();
        dto.setId(comuna.getId());
        dto.setNombre(comuna.getNombre());

        if (comuna.getRegion() != null) {
            dto.setRegion(comuna.getRegion());
        }

        List<String> sucursales = new ArrayList<>();
        if (comuna.getSucursales() != null) {
            for (Sucursal s : comuna.getSucursales()) {
                sucursales.add(s.getNombre());
            }
        }
        dto.setSucursales(sucursales);

        List<String> colaboradores = new ArrayList<>();
        if (comuna.getColaboradores() != null) {
            for (Colaborador c : comuna.getColaboradores()) {
                colaboradores.add(c.getNombres() + " " + c.getApellidos());
            }
        }
        dto.setColaboradores(colaboradores);

        return dto;
    }

}
