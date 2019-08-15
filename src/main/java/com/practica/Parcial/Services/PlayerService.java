package com.practica.Parcial.Services;

import com.practica.Parcial.Models.Player;
import com.practica.Parcial.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void save(Player player){
        playerRepository.save(player);
    }

    public void delete(Player player){
        playerRepository.delete(player);
    }

    public Optional<Player> findById(Integer id){
        return playerRepository.findById(id);
    }

    public List<Player> findAll(){
        return playerRepository.findAll();
    }

    public List<Player> findByTeamName(String teamName){
        return playerRepository.findByTeamName(teamName);
    }
}
