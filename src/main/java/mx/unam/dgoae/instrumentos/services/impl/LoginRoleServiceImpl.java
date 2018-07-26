/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services.impl;

import java.util.List;
import mx.unam.dgoae.instrumentos.dao.LoginDAO;
import mx.unam.dgoae.instrumentos.dao.LoginRolDAO;
import mx.unam.dgoae.instrumentos.entity.Login;
import mx.unam.dgoae.instrumentos.entity.LoginRol;
import mx.unam.dgoae.instrumentos.services.LoginRoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author UNAM
 */
public class LoginRoleServiceImpl implements LoginRoleService{

    @Autowired
    private LoginRolDAO  loginRolDAO;
    
    @Autowired
    private LoginDAO ldao;
    
    @Override
    public Login loginWithCurp(String cCurp) {
        
        List<LoginRol> loginroles = loginRolDAO.findAll();
        
        for(LoginRol lrol : loginroles){
        
            Login user = ldao.findOne(lrol.getIdUsuario().getIdUsuario());
            if(user.getCCurp().equals(cCurp))
            {
             
                return lrol.getIdUsuario();
            }
            
        }
        return null;
    }
     
}
