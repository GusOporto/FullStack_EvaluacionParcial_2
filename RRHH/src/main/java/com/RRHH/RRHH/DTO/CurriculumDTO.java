package com.RRHH.RRHH.DTO;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "nombre", "edad", "experienciaLaboral", "certificaciones","habilidades", "fortalezas", "idiomas" })
public class CurriculumDTO {

    private Long id;
    private String nombre;
    private Integer edad;
    private String experienciaLaboral;
    private String certificaciones;
    private String habilidades;
    private String fortalezas;
    private String idiomas;
    
}
