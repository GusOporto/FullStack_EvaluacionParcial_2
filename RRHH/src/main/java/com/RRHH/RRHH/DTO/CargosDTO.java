package com.RRHH.RRHH.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nombre", "descripcion", "sueldo" })
public class CargosDTO {

private Long id;
private String nombre;
private String descripcion;
private Integer sueldo;


}
