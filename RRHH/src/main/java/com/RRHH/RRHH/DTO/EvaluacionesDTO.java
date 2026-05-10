package com.RRHH.RRHH.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class EvaluacionesDTO {

    private Long id;
    private Date fechaEvaluacion;
    private String periodo;
    private String observaciones;
    private String fortalezas;
    private String debilidades;
    private String porMejorar;

}
