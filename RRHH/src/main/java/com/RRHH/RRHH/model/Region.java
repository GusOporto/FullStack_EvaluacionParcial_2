package com.RRHH.RRHH.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "regiones")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique = true, nullable = false, length = 100)
    private String nombre;

    // Relaciones
    @OneToMany(mappedBy = "region")
    private List<Comuna> comunas;

    @OneToMany(mappedBy = "region")
    private List<Sucursal> sucursales;

    @OneToMany(mappedBy = "region")
    private List<Colaborador> colaboradores;
}
