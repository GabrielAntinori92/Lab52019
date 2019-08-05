package com.practica.Parcial.Repositories;

import com.practica.Parcial.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Integer> {
    Team findByName(String name);
}
