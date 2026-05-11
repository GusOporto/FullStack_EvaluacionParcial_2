package com.RRHH.RRHH.model;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "evaluaciones")
//CLASE DE EVALUACION DESEMPEÑO EN RRHH
public class Evaluaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
/*
- evaluadorId (quién evaluó)

    @ManyToOne
    @JoinColumn(name= "Colaborador_id")
    private Colaborador Colaborador; //Persona Evaluada
*/
    @Column(nullable= false)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date fechaEvaluacion;

    @Column(nullable= false, length = 50)
    private String periodo; //Ej: Semestre 1 2026

    @NotBlank (message = "Las Observaciones son obligatorias")
    @Size(min = 2, max = 650, message = "La experiencia debe tener al menos 2 caracteres")
    @Column(nullable = false, length = 650)
    private String observaciones;

    @NotBlank (message = "Las fortalezas son obligatorias")
    @Size(min = 2, max = 250, message = "Las fortalezas deben tener al menos 2 caracteres")
    @Column(nullable = false, length = 250)
    private String fortalezas;

    @NotBlank (message = "Las habilidades son obligatorias")
    @Size(min = 2, max = 250, message = "Las habilidades deben tener al menos 2 caracteres")
    @Column(nullable = false, length = 250)
    private String debilidades;

    @NotBlank (message = "Las mejoras son obligatorias")
    @Size(min = 2, max = 250, message = "Las mejoras deben tener al menos 2 caracteres")
    @Column(nullable = false, length = 250)
    private String porMejorar;

    //Relaciones

    @OneToMany(mappedBy = "evaluaciones")
    private List<Evaluaciones> Evaluaciones;

}
