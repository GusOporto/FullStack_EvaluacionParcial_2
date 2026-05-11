package com.RRHH.RRHH.model;

import java.util.List;

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
@Table(name = "cargos")
// CLASE DE CARGOS EN RRHH
public class Cargos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 55, message = "El nombre debe tener entre 2 y 55 caracteres")
    @Column(nullable = false, length = 55)
    private String nombre;// Ej: "Cajero", "Reponedor", "Gerente de Tienda", "Bodeguero"

    @NotBlank(message = "La descripcion es obligatoria")
    @Size(min = 2, max = 550, message = "La descripcion debe tener al menos 2 caracteres")
    @Column(nullable = false, length = 550)
    private String descripcion;

    @Column(nullable = false)
    private Integer sueldo;

    //Relaciones

    @OneToMany(mappedBy = "colaboradores") 
    private List<Colaborador> colaboradores;

}
