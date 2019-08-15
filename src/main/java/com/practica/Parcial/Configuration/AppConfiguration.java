package com.practica.Parcial.Configuration;

import com.practica.Parcial.Models.Player;
import com.practica.Parcial.Models.PlayerDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean("Model-Mapper")
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<PlayerDTO, Player>() {
            @Override //Destination = Player, Source = PlayerDTO
            protected void configure() {
                map().setName(source.getPlayerName());
                map().getTeam().setName(source.getTeamName());
            }
        });

        modelMapper.addMappings(new PropertyMap<Player, PlayerDTO>() {
            @Override//Destination = PlayerDTO, Source = Player
            protected void configure() {
                map().setPlayerName(source.getName());
                map().setTeamName(source.getTeam().getName());
            }
        });

        return modelMapper;

    }

}
