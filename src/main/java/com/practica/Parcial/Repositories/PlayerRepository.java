package com.practica.Parcial.Repositories;

import com.practica.Parcial.Models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "select * from player p" +
            " join team t on p.id_equipo = t.id" +
            " where t.name = ?1",nativeQuery = true)
    List<Player> findByTeamName(String name);
}
