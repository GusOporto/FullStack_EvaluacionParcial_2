package com.RRHH.RRHH.DTO;

import java.util.List;

import com.RRHH.RRHH.model.Comuna;
import com.RRHH.RRHH.model.Region;

import lombok.Data;

@Data
public class SucursalDTO {
    private Long id;
    private String nombre;
    private String direccion;

    private Region region;
    private Comuna comuna;
    private List<String> colaboradores;
}
