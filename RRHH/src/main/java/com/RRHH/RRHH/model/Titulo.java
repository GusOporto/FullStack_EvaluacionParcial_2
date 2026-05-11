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
@Table(name= "titulo")
//CLASE DE TITULO EN RRHH
public class Titulo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(min=5, max=55)
    @Column(nullable= false, length = 55) 
    @NotBlank (message = "El nombre es obligatorio")
    private String nombre; // "Técnico en Administración", "Ingeniero Comercial", etc.

    @NotBlank (message = "La institucion es obligatoria")
    @Size(min = 2, max = 50, message = "La institucion deben tener al menos 2 caracteres")
    @Column(nullable = false, length = 50)
    private String institucion;

    @Column(nullable= false)
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date fechaObtencion;

    //Relaciones

    @ManyToMany(mappedBy = "titulos")
    private List<Colaborador> colaboradores;




}
