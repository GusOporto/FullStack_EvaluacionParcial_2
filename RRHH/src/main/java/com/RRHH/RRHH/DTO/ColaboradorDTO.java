package com.RRHH.RRHH.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.sql.Date;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "run", "nombres", "apellidos", "fechaNacimiento", "telefono", "correo", "direccion",
        "region", "comuna", "sucursales" })
public class ColaboradorDTO {
    private Long id;
    private String run;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String telefono;
    private String correo;
    private String direccion;

    private List<String> sucursales;
    private String region;
    private String comuna;
}
