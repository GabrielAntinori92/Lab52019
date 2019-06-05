package com.laboratorio.Parcial1.Controllers;


import com.laboratorio.Parcial1.Models.Usuario;
import com.laboratorio.Parcial1.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("")
    public void add(@RequestBody Usuario usr, @RequestHeader(value="User-Agent") String browser){

        usr.setBrowser(browser);

        usuarioRepository.save(usr);
    }

    @DeleteMapping("/{usuarioId}")
    public void delete(@PathVariable Integer usuarioId){
        usuarioRepository.deleteById(usuarioId);
    }

    @PutMapping("/{usuarioId}")
    public void update(@PathVariable Integer usuarioId, @RequestBody Usuario usr_update, @RequestHeader("User-Agent") String browser){
        Usuario usr = usuarioRepository.getOne(usuarioId);

        usr.setNombre(usr_update.getNombre());
        usr.setApellido(usr_update.getApellido());
        usr.setBrowser(browser);

        usuarioRepository.save(usr);
    }

    @GetMapping("")
    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{usuarioId}")
    public Usuario getById(@PathVariable Integer usuarioId){
        return usuarioRepository.getOne(usuarioId);
    }
}
