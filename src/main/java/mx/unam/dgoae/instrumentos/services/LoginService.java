/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services;

import mx.unam.dgoae.instrumentos.dto.NewPassword;
import mx.unam.dgoae.instrumentos.entity.Login;

/**
 *
 * @author UNAM
 */


public interface LoginService {
    
    boolean nuevoLogin(String curp, String pass);
    Login changePassword(NewPassword passwords);
    
}
