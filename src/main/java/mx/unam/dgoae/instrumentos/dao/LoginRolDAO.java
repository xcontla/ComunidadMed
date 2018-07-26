/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dao;

import mx.unam.dgoae.instrumentos.entity.LoginRol;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author UNAM
 */
public interface LoginRolDAO extends JpaRepository<LoginRol, Long>{
    
    
    /*@Query(value = "SELECT l.idUsuario FROM LoginRol l INNER JOIN l.idUsuario u WHERE u.cCurp = ?1")
    Login findByCCurpWithData(String cCurp);*/
}
