package com.RRHH.RRHH.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class TituloDTO {

    private Long id;
    private String nombre;
    private String institucion;
    private Date fechaObtencion;


}
