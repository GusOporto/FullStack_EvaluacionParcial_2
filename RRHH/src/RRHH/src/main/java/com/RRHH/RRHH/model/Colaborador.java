package com.RRHH.RRHH.model;

import jakarta.persistence.*;


@Entity
@Table(name = "colaboradores")
public class Colaborador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Rellenar luego, esta solo para que funcione
    //Gus tiene esta clase


}
