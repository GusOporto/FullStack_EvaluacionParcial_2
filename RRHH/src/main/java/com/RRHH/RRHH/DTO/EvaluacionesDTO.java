package com.RRHH.RRHH.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "id", "fechaEvaluacion", "periodo", "observaciones", "fortalezas", "debilidades", "porMejorar" })
public class EvaluacionesDTO {

    private Long id;
    private LocalDate fechaEvaluacion;
    private String periodo;
    private String observaciones;
    private String fortalezas;
    private String debilidades;
    private String porMejorar;

}
