package com.RRHH.RRHH.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

import lombok.Data;

@Data
@JsonFormat(pattern = "yyyy-MM-dd")
@JsonPropertyOrder({ "id", "run", "nombres", "apellidos", "fechaNacimiento", "telefono", "correo", "direccion",
        "region", "comuna", "sucursales" })
public class ColaboradorDTO {
    private Long id;
    private String run;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String correo;
    private String direccion;
    // Relaciones
    private List<String> sucursales;
    private String region;
    private String comuna;
}
