/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.controllers;

import java.security.Principal;
import mx.unam.dgoae.instrumentos.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author UNAM
 */
@Controller
@RequestMapping("/usuario/home.dgoae")
public class UserController {

    @Autowired
    private LoginService loginService;


   @RequestMapping(value = "/principal", method = RequestMethod.GET)
    public String getmyHome(Principal user) {
        
        System.out.println(user.getName());
        return "/usuario/partials/init";
    }
    
    @RequestMapping(value = "/resultadosHyM", method = RequestMethod.GET)
    public String resultadosHyM(Principal user) {
        
        System.out.println(user.getName());
        return "/usuario/partials/resultadosHyM";
    }
}
