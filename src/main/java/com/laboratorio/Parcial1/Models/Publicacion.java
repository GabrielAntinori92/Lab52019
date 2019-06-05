package com.laboratorio.Parcial1.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;
    private String foto;
    private Date fechapublicacion;
    private boolean liked;

}
