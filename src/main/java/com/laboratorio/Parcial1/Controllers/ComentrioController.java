package com.laboratorio.Parcial1.Controllers;

import com.laboratorio.Parcial1.Models.Comentario;
import com.laboratorio.Parcial1.Models.Publicacion;
import com.laboratorio.Parcial1.Repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/comentarios")
public class ComentrioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @PostMapping("/{publicacionId}")
    public void add(@PathVariable Integer publicacionId, @RequestBody Comentario comentario){

        Date fecha = new Date();

        comentario.setFecha(fecha);
        comentario.setPublicacion(new Publicacion(publicacionId,"","","",false));

        comentarioRepository.save(comentario);

    }
}
