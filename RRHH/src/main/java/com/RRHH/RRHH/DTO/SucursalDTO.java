package com.RRHH.RRHH.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nombre", "region", "comuna", "direccion", "colaboradores" })
public class SucursalDTO {
    private Long id;
    private String nombre;
    private String direccion;

    private String region;
    private String comuna;
    private List<String> colaboradores;
}
