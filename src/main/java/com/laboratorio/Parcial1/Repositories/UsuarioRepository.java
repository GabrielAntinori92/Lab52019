package com.laboratorio.Parcial1.Repositories;

import com.laboratorio.Parcial1.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
