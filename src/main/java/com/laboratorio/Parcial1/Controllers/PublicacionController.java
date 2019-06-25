package com.laboratorio.Parcial1.Controllers;

import com.laboratorio.Parcial1.Models.Publicacion;
import com.laboratorio.Parcial1.Models.PublicacionDTO;
import com.laboratorio.Parcial1.Models.Usuario;
import com.laboratorio.Parcial1.Repositories.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @PostMapping("/{usuarioId}")
    public void add(@PathVariable Integer usuarioId, @RequestBody Publicacion p){
        Date fecha = new Date();

        p.setFecha(fecha);
        p.setUsuario(new Usuario(usuarioId,"","",""));

        publicacionRepository.save(p);
    }

    @GetMapping("/{titulo}")
    public PublicacionDTO findByTitle(@PathVariable String titulo){

        return publicacionRepository.findByTitulo(titulo);
    }

    @GetMapping("/publicaciones")
    public List<Publicacion> getAll(){
        return publicacionRepository.findAll();
    }

}
