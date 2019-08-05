package com.practica.Parcial.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class PlayerDTO {
    Integer id;
    String name;
    String l_name;
    String team_name;
}
