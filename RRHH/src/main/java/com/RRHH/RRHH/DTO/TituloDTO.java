package com.RRHH.RRHH.DTO;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nombre", "institucion", "fechaObtencion"})
public class TituloDTO {

    private Long id;
    private String nombre;
    private String institucion;
    private Date fechaObtencion;


}
