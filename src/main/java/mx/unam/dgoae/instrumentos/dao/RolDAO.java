/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dao;

import mx.unam.dgoae.instrumentos.entity.CatRol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UNAM
 */
public interface RolDAO extends JpaRepository<CatRol, Integer>{
    
    CatRol findByCnombreRol(String cnombreRol);
    
}
