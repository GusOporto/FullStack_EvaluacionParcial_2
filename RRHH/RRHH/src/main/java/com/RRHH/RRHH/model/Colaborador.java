package com.RRHH.RRHH.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="colaboradores")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Debe indicar un Run valido, sin punto ni guion.")
    @Size(min= 8, max= 9, message = "El Run debe tener entre 8 y 9 digitos.")
    @Column(nullable = false, length = 9)
    private String run;

    @NotBlank(message = "El nombre no puede estar vacio.")
    @Column(nullable = false, length = 100)
    private String nombres;

    @NotBlank(message = "El apellido no puede estar vacio.")
    @Column(nullable = false, length = 100)
    private String apellidos;   

    @NotNull(message = "Ingrese una fecha valida. ej: 01-12-2000")
    @Past(message = "La fecha de nacimiento debe ser en el pasado.")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(nullable = false, length = 10)
    private Date fechaNacimiento;

    @NotBlank(message = "Ingrese un numero de telefono valido.")
    @Column(nullable = false, length = 11)
    private String telefono;

    @Email(message = "Ingrese un correo valido.")
    @Column(unique = true, nullable = true, length = 100)
    private String correo;

    @NotBlank(message = "Debe ingresar una direccion valida.")
    @Column(nullable = false, length = 200)
    private String direccion;

    //Relaciones
    /*
    @ManyToOne
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @ManyToOne
    @JoinColumn(name = "comuna_id", nullable = false)
    private Comuna comuna;

    @OneToMany
    @JoinColumn(name = "evaluacion_id", nullable = true)
    private Evaluaciones evaluaciones;
    */
}
