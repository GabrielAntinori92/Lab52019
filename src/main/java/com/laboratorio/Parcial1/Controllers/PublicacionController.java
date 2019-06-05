package com.laboratorio.Parcial1.Controllers;

import com.laboratorio.Parcial1.Models.Publicacion;
import com.laboratorio.Parcial1.Models.Usuario;
import com.laboratorio.Parcial1.Repositories.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class PublicacionController {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @PostMapping("/{usuarioId}/publicaciones")
    public void add(@PathVariable Integer usuarioId, @RequestBody Publicacion p){

        p.setUsuario(new Usuario(usuarioId,"","",""));

        publicacionRepository.save(p);
    }

    @GetMapping("/publicaciones")
    public List<Publicacion> getAll(){
        return publicacionRepository.findAll();
    }

}
