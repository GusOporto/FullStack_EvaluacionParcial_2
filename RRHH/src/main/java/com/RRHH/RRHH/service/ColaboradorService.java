package com.RRHH.RRHH.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RRHH.RRHH.DTO.ColaboradorDTO;
import com.RRHH.RRHH.model.Colaborador;
import com.RRHH.RRHH.model.Sucursal;
import com.RRHH.RRHH.repository.ColaboradorRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<ColaboradorDTO> findAll() {
        return colaboradorRepository.findAll().stream()
                .map(this::convertirADTO)
                .toList();
    }

    public ColaboradorDTO findById(Long id) {
        Colaborador colaborador = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colaborador no encontrado."));
        return convertirADTO(colaborador);
    }

    public Colaborador save(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    public String delete(Long id) {
        try {
            Colaborador colaborador = colaboradorRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("No se pudo borrar el Colaborador ID: " + id + ", no existe."));
            colaboradorRepository.delete(colaborador);
            return "El Colaborador ID: " + id + " ha sido eliminado exitosamente.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public Colaborador updateColaborador(Long id, Colaborador col1) {
        Colaborador col2 = colaboradorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El Colaborador no existe."));
        if (col1.getRun() != null) {
            col2.setRun(col1.getRun());
        }
        if (col1.getNombres() != null) {
            col2.setNombres(col1.getNombres());
        }
        if (col1.getApellidos() != null) {
            col2.setApellidos(col1.getApellidos());
        }
        if (col1.getFechaNacimiento() != null) {
            col2.setFechaNacimiento(col1.getFechaNacimiento());
        }
        if (col1.getTelefono() != null) {
            col2.setTelefono(col1.getTelefono());
        }
        if (col1.getCorreo() != null) {
            col2.setCorreo(col1.getCorreo());
        }
        if (col1.getDireccion() != null) {
            col2.setDireccion(col1.getDireccion());
        }
        return colaboradorRepository.save(col2);
    }

    public List<ColaboradorDTO> findByRun(String run) {
        return colaboradorRepository.findByRun(run).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<ColaboradorDTO> findBySucursales(Long id) {
        return colaboradorRepository.findBySucursales(id).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<ColaboradorDTO> findByComuna(Long id) {
        return colaboradorRepository.findByComuna(id).stream()
                .map(this::convertirADTO)
                .toList();
    }

    public List<ColaboradorDTO> findByRegion(Long id) {
        return colaboradorRepository.findByRegion(id).stream()
                .map(this::convertirADTO)
                .toList();
    }

    private ColaboradorDTO convertirADTO(Colaborador colaborador) {
        ColaboradorDTO dto = new ColaboradorDTO();
        dto.setId(colaborador.getId());
        dto.setRun(colaborador.getRun());
        dto.setNombres(colaborador.getNombres());
        dto.setApellidos(colaborador.getApellidos());
        dto.setFechaNacimiento(colaborador.getFechaNacimiento());
        dto.setTelefono(colaborador.getTelefono());
        dto.setCorreo(colaborador.getCorreo());
        dto.setDireccion(colaborador.getDireccion());

        List<String> sucursales = new ArrayList<>();
        if (colaborador.getSucursales() != null) {
            for (Sucursal s : colaborador.getSucursales()) {
                sucursales.add(s.getNombre());
            }
        }
        dto.setSucursales(sucursales);

        if (colaborador.getRegion() != null) {
            dto.setRegion(colaborador.getRegion());
        }

        if (colaborador.getComuna() != null) {
            dto.setComuna(colaborador.getComuna());
        }
        return dto;
    }
}
