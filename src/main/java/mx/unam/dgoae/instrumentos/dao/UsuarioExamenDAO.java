/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dao;

import java.util.List;
import mx.unam.dgoae.instrumentos.entity.CatExamen;
import mx.unam.dgoae.instrumentos.entity.Login;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UNAM
 */
public interface UsuarioExamenDAO extends JpaRepository<UsuarioExamen,Integer>{

    public List<UsuarioExamen> findByIdUsuarioAndIdExamen(Login us, CatExamen idEx);
    
}
