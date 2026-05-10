package com.RRHH.RRHH.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nombre", "descripcion" })
public class AreaDTO {

    private Long id;
    private String nombre;
    private String descripcion;

}
