package com.RRHH.RRHH.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name= "curriculum")
//CLASE DE CURRICULUM EN RRHH
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    @OneToOne
    @JoinColumn(name= "curriculum_id", nullable = true)
    private Colaborador Colaborador;
    */
    @Size(min=2, max=75, message = "El nombre debe tener entre 2 y 75 caracteres")
    @Column(nullable= false, length = 75) 
    @NotBlank (message = "El nombre es obligatorio")
    private String nombre;
    
    //@Size(min=2, max=35) ASI DABA ERROR
    @Min(18)
    @Max(61)
    @NotNull
    private Integer edad;

    @NotBlank (message = "La experiencia es obligatoria")
    @Size(min = 2, max = 450, message = "La experiencia debe tener al menos 2 caracteres")
    @Column(nullable = false, length = 450)
    private String experienciaLaboral;

    @Lob
    @Column(nullable= true)
    private String certificaciones;

    @NotBlank (message = "Pon al menos una habilidad")
    @Size(min = 2, max = 350, message = "Tu/s habilidad/es debe contener al menos 2 caracteres")
    @Column(nullable = false, length = 350)
    private String habilidades;

    @NotBlank (message = "Poner al menos una fortaleza")
    @Size(min = 2, max = 250, message = "La fortaleza debe tener al menos 2 caracteres")
    @Column(nullable = false, length = 250)
    private String fortalezas;

    @Column(nullable= false, length =  100)
    private String idiomas;
}
