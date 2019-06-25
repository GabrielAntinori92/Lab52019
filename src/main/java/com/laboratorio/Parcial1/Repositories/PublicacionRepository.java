package com.laboratorio.Parcial1.Repositories;

import com.laboratorio.Parcial1.Models.Publicacion;
import com.laboratorio.Parcial1.Models.PublicacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

    @Query(value = "select p.titulo as titulo, s.nombre as nombre, count(p.comentario_id) as cantidad from publicacion p join usuario s where p.usuario_id = usuario_id group by p.titulo", nativeQuery = true)
    PublicacionDTO findByTitulo(String titulo);
}
