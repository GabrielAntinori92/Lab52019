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
import javax.validation.constraints.NotNull;
import javax.xml.ws.Response;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    @Autowired
    @Qualifier("Model-Mapper")
    private ModelMapper modelMapper;

    @PostMapping(value = "")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void save(@Valid @RequestBody Player player){


        if(!teamService.findById(player.getTeam().getId()).isPresent())
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Player must be added to existent Team");

        playerService.save(player);

    }

    @DeleteMapping(value = "/{idPlayer}")
    public void delete(@PathVariable Integer idPlayer){

        Player player = playerService.findById(idPlayer).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Player Id not found"));

        playerService.delete(player);

    }

    @GetMapping(value = "/{idPlayer}")
    public ResponseEntity<PlayerDTO> findById(@PathVariable Integer idPlayer){

        Player player = playerService.findById(idPlayer).orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Player id not found"));
        PlayerDTO playerDTO = convertToDto(player);

        return ResponseEntity.status(HttpStatus.OK).body(playerDTO);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<PlayerDTO>> findAll(){

        try{
            List<Player> players = playerService.findAll();
            List<PlayerDTO> playerDTOList = players.stream()
                    .map(player -> convertToDto(player))
                    .collect(Collectors.toList());

            if(!playerDTOList.isEmpty()){
                return ResponseEntity.ok(playerDTOList);
            }else
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(playerDTOList);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{teamName}")
    public ResponseEntity<List<PlayerDTO>> findByTeamName(@PathVariable String teamName){

        List<Player> players = null;

        if(nonNull(teamService.findByName(teamName))){
            players = playerService.findByTeamName(teamName);
        }

        List<PlayerDTO> playerDTOList = players.stream()
                .map(player -> convertToDto(player))
                .collect(Collectors.toList());

        if(!playerDTOList.isEmpty()){
            return ResponseEntity.ok(playerDTOList);
        }else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(playerDTOList);
    }

    private PlayerDTO convertToDto(Player player){
        return modelMapper.map(player,PlayerDTO.class);
    }

    private Player convertToEntity(PlayerDTO playerDTO){
        return modelMapper.map(playerDTO,Player.class);
    }
}
