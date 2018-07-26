/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.support;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mx.unam.dgoae.instrumentos.entity.CatRol;
import mx.unam.dgoae.instrumentos.entity.Login;
//import mx.unam.dgoae.instrumentos.entity.LoginRol;
import mx.unam.dgoae.instrumentos.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author UNAM
 */
public class MyUserPrincipal implements UserDetails{

    @Autowired
    private RolService rolService;
   
    private final Login user;
 
    public MyUserPrincipal(Login user) {
        this.user = user;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<CatRol> roles = rolService.allroles();//user.getLoginRolList();
        ArrayList<GrantedAuthority> auths = new ArrayList<>();
        for(CatRol rol : roles){
            if(rol.getIdRol()== 1)
                auths.add(new SimpleGrantedAuthority(rol.getCnombreRol()));
        }
        
        return auths;
    }

    @Override
    public String getPassword() {
       return user.getCLlave();
    }

    @Override
    public String getUsername() {
        return user.getCCurp();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
            return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getBStatus();
    }
    
}
