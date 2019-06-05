package com.laboratorio.Parcial1.Repositories;

import com.laboratorio.Parcial1.Models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
