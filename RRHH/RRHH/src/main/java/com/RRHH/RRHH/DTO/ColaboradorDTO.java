package com.RRHH.RRHH.DTO;

import java.util.List;

import com.RRHH.RRHH.model.Comuna;
import com.RRHH.RRHH.model.Region;
import java.sql.Date;

import lombok.Data;

@Data
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
    private Region region;
    private Comuna comuna;
}
