package com.practica.Parcial.Services;

import com.practica.Parcial.Models.Team;
import com.practica.Parcial.Repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public void save(Team team){
        teamRepository.save(team);
    }

    public void delete(Team team){
        teamRepository.delete(team);
    }

    public Optional<Team> findById(Integer id){
        return teamRepository.findById(id);
    }

    public List<Team> findAll(){
        return teamRepository.findAll();
    }

    public Team findByName(String name){
        return teamRepository.findByName(name);
    }

}
