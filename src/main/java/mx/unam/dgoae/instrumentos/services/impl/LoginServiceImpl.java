/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services.impl;

import java.util.Date;
import mx.unam.dgoae.instrumentos.dao.LoginDAO;
import mx.unam.dgoae.instrumentos.dao.LoginRolDAO;
import mx.unam.dgoae.instrumentos.dao.RolDAO;
import mx.unam.dgoae.instrumentos.dto.NewPassword;
import mx.unam.dgoae.instrumentos.entity.CatRol;
import mx.unam.dgoae.instrumentos.entity.Login;
import mx.unam.dgoae.instrumentos.entity.LoginRol;
import mx.unam.dgoae.instrumentos.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author UNAM
 */
public class LoginServiceImpl implements LoginService {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private LoginRolDAO loginRolDAO;
    
    @Autowired
    private RolDAO rolDAO;

    @Override
    public boolean nuevoLogin(String curp, String pass) {

        LOGGER.debug("Nuevo Login --- ");
    
        Login nuevo = loginDAO.findByCCurp(curp);
        
        if(nuevo != null){
             LOGGER.debug("Login existe");
            return false;
        }
         LOGGER.debug("Nuevo usuario");
        nuevo  = new Login();
        nuevo.setBStatus(true);
        nuevo.setCCurp(curp);
        nuevo.setCLlave(pass);
        nuevo.setDCreacion(new Date());
        
        loginDAO.save(nuevo);
        CatRol idRol = rolDAO.findByCnombreRol("ROLE_USUARIO");
        
        LoginRol logRol = new LoginRol();
        logRol.setIdUsuario(nuevo);
        logRol.setIdRol(idRol);
        logRol.setDCreacion(new Date());
        
        loginRolDAO.saveAndFlush(logRol);
        
        return true;
    }

    @Override
    public Login changePassword(NewPassword passwords) {
        Login nuevo = loginDAO.findByCCurp(passwords.getUsername());
        nuevo.setCLlave(bCryptPasswordEncoder.encode(passwords.getNewpassword()));
        loginDAO.saveAndFlush(nuevo);
        
        return nuevo;
    }
    
    

}
