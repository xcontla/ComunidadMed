/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dao;

import java.util.List;
import mx.unam.dgoae.instrumentos.entity.CatExamen;
import mx.unam.dgoae.instrumentos.entity.CatParte;
import mx.unam.dgoae.instrumentos.entity.CatSeccion;
import mx.unam.dgoae.instrumentos.entity.ExamenPregunta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UNAM
 */
public interface ExamenPreguntaDAO extends JpaRepository<ExamenPregunta, Long> {

    public List<ExamenPregunta> findByIdExamenAndIdParteAndIdSeccion(CatExamen idExamen, CatParte idParte, CatSeccion idSeccion);

}
