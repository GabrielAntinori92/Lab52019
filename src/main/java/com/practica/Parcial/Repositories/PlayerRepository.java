package com.practica.Parcial.Repositories;

import com.practica.Parcial.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
