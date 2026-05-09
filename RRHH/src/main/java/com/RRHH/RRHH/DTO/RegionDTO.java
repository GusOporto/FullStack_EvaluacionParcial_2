package com.RRHH.RRHH.DTO;

import java.util.List;

import lombok.Data;

@Data
public class RegionDTO {
    private Long id;
    private String nombre;

    private List<String> comunas;
    private List<String> sucursales;
    private List<String> colaboradores;
}
