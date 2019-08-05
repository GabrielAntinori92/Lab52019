package com.practica.Parcial.Controllers;

import com.practica.Parcial.Models.Team;
import com.practica.Parcial.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(value = "teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody Team team){

        if(nonNull(teamService.findByName(team.getName())))
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Team name already exists");

        teamService.save(team);

    }

    @DeleteMapping(value = "/{idTeam}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer idTeam){
        Team team = teamService.findById(idTeam).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Team id not found"));

        teamService.delete(team);
    }

    @GetMapping(value = "/{idTeam}")
    public ResponseEntity<Team> findById(@PathVariable Integer idTeam){

        Team team = teamService.findById(idTeam).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Team id not found"));

        return ResponseEntity.ok(team);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Team>> findAll(){
        List<Team> teams = teamService.findAll();

        if(teams.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(teams);
        }else{
            return ResponseEntity.ok(teams);
        }

    }

}
