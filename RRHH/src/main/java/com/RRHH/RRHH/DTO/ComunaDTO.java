package com.RRHH.RRHH.DTO;

import java.util.List;

import com.RRHH.RRHH.model.Region;
import lombok.Data;

@Data
public class ComunaDTO {
    private Long id;
    private String nombre;

    private Region region;
    private List<String> sucursales;
    private List<String> colaboradores;

}
