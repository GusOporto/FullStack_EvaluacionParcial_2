package com.RRHH.RRHH.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tipo_Contracto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoContrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre del contrato es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;
    
    @Size(max = 300, message = "La descripción no puede superar los 300 caracteres")
    private String descripcion;
    
    @NotBlank(message = "La modalidad es obligatoria")
    @Column(nullable = false, length = 50)
    private String modalidad;

    @NotBlank(message = "La jornada es obligatoria")
    @Column(nullable = false, length = 50)
    private String jornada;
    
    @NotNull(message = "La fecha de creación es obligatoria")
    @Column(nullable = false)
    private LocalDate fechaCreacion;

  

    //@OneToMany(mappedBy = "tipoContrato")
    //@ToString.Exclude
    //private List<Colaborador> colaboradores;


}


