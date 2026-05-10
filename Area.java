package com.RRHH.RRHH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "areas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del área es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 300, message = "La descripción no puede superar los 300 carecteres")
    private String descripcion;

    //@OneToMany(mappedBy = "area")
    //@ToString.Exclude
    //private List<Colaborador> colaboradores;
}
