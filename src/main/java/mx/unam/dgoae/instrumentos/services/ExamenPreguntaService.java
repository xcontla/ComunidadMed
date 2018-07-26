/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services;

import java.util.Map;
import mx.unam.dgoae.instrumentos.dto.DatosRespuestas;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;

/**
 *
 * @author UNAM
 */
public interface ExamenPreguntaService {
    
    Map<String, Object> getPreguntasFromIds(Integer examen, Integer parte, Integer seccion); 
    UsuarioExamen getUsuarioExamen(DatosRespuestas dato, String username); 
}
