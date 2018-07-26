/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dao;

import java.util.List;
import mx.unam.dgoae.instrumentos.entity.ExamenPregunta;
import mx.unam.dgoae.instrumentos.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UNAM
 */
public interface PreguntaDAO extends JpaRepository<Pregunta,Long>{

    public List<Pregunta> findByIdExamenPreguntaAndBStatus(ExamenPregunta exaPreg, boolean b);
    
}
