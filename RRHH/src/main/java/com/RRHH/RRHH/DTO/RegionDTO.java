package com.RRHH.RRHH.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nombre", "comunas", "sucursales", "colaboradores" })
public class RegionDTO {
    private Long id;
    private String nombre;

    private List<String> comunas;
    private List<String> sucursales;
    private List<String> colaboradores;
}
