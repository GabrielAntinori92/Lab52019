package com.practica.Parcial.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean("Model-Mapper")
    public ModelMapper createMapper(){

        return new ModelMapper();
    }

}
