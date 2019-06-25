package com.laboratorio.Parcial1.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor @AllArgsConstructor
public class PublicacionDTO {
    private String titulo;
    private String duenio;
    private Integer cantidad;
}
