package com.laboratorio.Parcial1.Repositories;

import com.laboratorio.Parcial1.Models.Publicacion;
import com.laboratorio.Parcial1.Models.PublicacionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublicacionRepository extends JpaRepository<Publicacion, Integer> {

        @Query(value = "select p.titulo, s.nombre, count(c.id) from publicacion p "
                + " inner join usuario s on p.usuario_id = s.id"
                + " inner join comentario c on p.comentario_id = c.id"
                + " where p.titulo = 'publicacione1'", nativeQuery = true)
    PublicacionDTO findByTitulo(String titulo);
}
