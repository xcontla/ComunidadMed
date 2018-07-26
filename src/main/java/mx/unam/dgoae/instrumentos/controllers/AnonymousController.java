/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.controllers;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.unam.dgoae.instrumentos.dto.NewPassword;
import mx.unam.dgoae.instrumentos.entity.Login;
import mx.unam.dgoae.instrumentos.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author UNAM
 */
@Controller
public class AnonymousController {

    @Autowired
    private LoginService loginService;

    /*@Autowired
    private LoginRoleService loginRoleService;*/

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(AnonymousController.class);

    private final String key = "12345678";

    @RequestMapping(value = "/login.dgoae", method = RequestMethod.GET)
    public String toLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/init/key/{llave}/key2/{llave2}", method = RequestMethod.GET)
    public ModelAndView initUser(@PathVariable(value = "llave") String llave,
            @PathVariable(value = "llave2") String llave2,
            HttpServletResponse httpServletResponse, HttpServletRequest request) {

        String curp = llave + key;
        String bcytpkey = llave2;
        LOGGER.debug(curp + "   " + bcytpkey);
        boolean matched = bCryptPasswordEncoder.matches(curp, bcytpkey);
        LOGGER.debug("EMPATA?" + matched);

        LOGGER.debug("ENTRO AL ALGO");
        if (matched) {
            boolean nuevo = loginService.nuevoLogin(llave, llave2);
            if(nuevo){
            Map<String, Object> map = new HashMap();
            map.put("result", "Favor de Cambiar tu contraseña!");
            map.put("user",llave);
            return new ModelAndView("changePassword", map);
            }else{
            Map<String, Object> map = new HashMap();
            map.put("result", "Inicie Sesión");
            
            return new ModelAndView("login", map);
            }
          
        }
        LOGGER.debug("No hace match el password");

        /*Generar los usuarios y hacer el login*/
       /* httpServletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        httpServletResponse.setHeader("Location", path + "/out.dgoae");*/
        return new ModelAndView("out", "result", "Verificar Registro en Medicina");
        //return "/out.dgoae";
    }
    
    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> initUser2( @RequestParam(value= "llave") String llave,
                                @RequestParam(value= "llave2") String llave2,
            HttpServletResponse httpServletResponse, HttpServletRequest request) {

        String curp = llave + key;
        String bcytpkey = llave2;
        LOGGER.debug(curp + "   " + bcytpkey);
        boolean matched = bCryptPasswordEncoder.matches(curp, bcytpkey);
        LOGGER.debug("EMPATA?" + matched);

        LOGGER.debug("ENTRO AL ALGO");
        if (matched) {
            //Z7VIIRQH
            boolean nuevo = loginService.nuevoLogin(llave, llave2);
            if(nuevo){
            String returnurl = "http://localhost:8080/ComunidadMED/changePassword.dgoae?result=Favor+de+Cambiar+tu+contrase%F1a%21&user="+llave ;
            /*Map<String, Object> map = new HashMap();
            map.put("result", "Favor de Cambiar tu contraseña!");
            map.put("user",llave);*/
            Map<String, Object> map = new HashMap();
            map.put("location", returnurl);
            return  map;
            //return returnurl;
            }else{
            String returnurl = "http://localhost:8080/ComunidadMED/login.dgoae?result=Inicie+Sesion&user="+llave ;
            Map<String, Object> map = new HashMap();
            map.put("location", returnurl);
            
             return map;
            //return returnurl;
            }
          
        }
        LOGGER.debug("No hace match el password");
         String returnurl = "http://localhost:8080/ComunidadMED/out.dgoae?result=Verificar+Registro+en+Medicina&user="+llave ;
        /*Generar los usuarios y hacer el login*/
       /* httpServletResponse.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        httpServletResponse.setHeader("Location", path + "/out.dgoae");*/
       Map<String, Object> map = new HashMap();
            map.put("location", returnurl);
        return map;
        
        //return returnurl;
    //return "/out.dgoae";
    }
    
    
    
    @RequestMapping(value="/change_password", method = RequestMethod.POST)
    public ModelAndView initUserAndSession(/*@RequestBody NewPassword passwords*/
                                @RequestParam(value= "username") String username,
                                @RequestParam(value= "newpassword") String newpass,
                                @RequestParam(value= "confirmpassword") String confirmpass){
        
        NewPassword passwords = new NewPassword(username, newpass, confirmpass);
         ModelAndView mvc;
        if(passwords.checkPassSymetic()){
            
            Login nuevo = loginService.changePassword(passwords);
            LOGGER.debug(nuevo + "<---- LOGIN");
            Map<String, Object> map = new HashMap();
            map.put("result", "Ahora puede iniciar sesión con su Identificador y nueva contraseña");
            map.put("username",username);
            mvc= new ModelAndView("login",map);
        }
        else
            mvc = new ModelAndView("changePassword","result", "Hubo un error, vuelva a cambiar el password");
        return mvc;
       
    }
    
    
    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String getFooter() {
        return "/partials/footer";
    }


    @RequestMapping(value = "/navigator", method = RequestMethod.GET)
    public String getNavigator() {
        return "/partials/navegator";
    }
    
    @RequestMapping(value = "/navigatorExamen", method = RequestMethod.GET)
    public String geNavigatorExamen() {
        return "/partials/navigatorExamen";
    }
}
