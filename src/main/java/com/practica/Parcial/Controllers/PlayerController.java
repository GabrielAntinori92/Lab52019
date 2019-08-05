package com.practica.Parcial.Controllers;

import com.practica.Parcial.Models.Player;
import com.practica.Parcial.Models.PlayerDTO;
import com.practica.Parcial.Models.Team;
import com.practica.Parcial.Services.PlayerService;
import com.practica.Parcial.Services.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@Valid @RequestBody Player player){

        if(player.getTeam() == null)
            throw new HttpClientErrorException( HttpStatus.BAD_REQUEST, "Team can't be null");

        if(!teamService.findById(player.getTeam().getId()).isPresent())
            teamService.save(player.getTeam());

        playerService.save(player);

    }

    @DeleteMapping(value = "/{idPlayer}")
    public void delete(@PathVariable Integer idPlayer){

        Player player = playerService.findById(idPlayer).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Player Id not found"));

        playerService.delete(player);

    }

    @GetMapping(value = "/{idPlayer}")
    public ResponseEntity<Player> findById(@PathVariable Integer idPlayer){

        Player player = playerService.findById(idPlayer).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Player id not found"));

        return ResponseEntity.status(HttpStatus.OK).body(player);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<Player>> findAll(){

        try{
            List<Player> players = playerService.findAll();

            if(!players.isEmpty()){
                return ResponseEntity.ok(players);
            }else
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(players);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
