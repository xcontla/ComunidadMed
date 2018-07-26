/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services;

import java.util.List;
import java.util.Map;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;

/**
 *
 * @author UNAM
 */
public interface UsuarioExamenService {
    
    List<UsuarioExamen> getExamenByUsernameAndIdExamen(String username, int idExamen);
    
    public Map<String, Object> getResultadosByUsuarioExamen(Integer idUE, String name);
}
