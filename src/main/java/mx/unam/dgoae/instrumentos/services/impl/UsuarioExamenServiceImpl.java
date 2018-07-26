/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.unam.dgoae.instrumentos.dao.ExamenDAO;
import mx.unam.dgoae.instrumentos.dao.LoginDAO;
import mx.unam.dgoae.instrumentos.dao.ResHyMDAO;
import mx.unam.dgoae.instrumentos.dao.UserHyMAptitudDAO;
import mx.unam.dgoae.instrumentos.dao.UserHyMInteresDAO;
import mx.unam.dgoae.instrumentos.dao.UsuarioExamenDAO;
import mx.unam.dgoae.instrumentos.entity.CatExamen;
import mx.unam.dgoae.instrumentos.entity.CatResultadoHerreraymontes;
import mx.unam.dgoae.instrumentos.entity.Login;
import mx.unam.dgoae.instrumentos.entity.UresoHymAptitud;
import mx.unam.dgoae.instrumentos.entity.UresoHymInteres;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;
import mx.unam.dgoae.instrumentos.services.UsuarioExamenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author UNAM
 */
public class UsuarioExamenServiceImpl implements UsuarioExamenService{

    public static final Logger LOGGER = LoggerFactory.getLogger(UsuarioExamenServiceImpl.class);
    
    @Autowired
    private UsuarioExamenDAO usuarioExamenDAO;

    @Autowired
    private LoginDAO loginDAO;
    
    @Autowired
    private ExamenDAO examenDAO;
    
    @Autowired
    private UserHyMAptitudDAO hyMAptitudDAO;
    
    @Autowired
    private UserHyMInteresDAO hyMInteresDAO;
    
    @Autowired
    private ResHyMDAO resHyMDAO;
            
    @Override
    public List<UsuarioExamen> getExamenByUsernameAndIdExamen(String username, int idExamen) {
        
        Login us = loginDAO.findByCCurp(username);
        CatExamen idEx = examenDAO.findOne(idExamen);
        
        return usuarioExamenDAO.findByIdUsuarioAndIdExamen(us,idEx);
    }

    @Override
    public Map<String, Object> getResultadosByUsuarioExamen(Integer idUE, String name) {
        
        LOGGER.debug(idUE + "   " + name);
        Login us = loginDAO.findByCCurp(name);
        
        Map<String, Object> json = new HashMap<>();
        switch(idUE){
        
            case 2:
                List<UresoHymInteres> inter = hyMInteresDAO.findByIdUsuario(us);
                json = procesarResultadosIntereses(inter);
                LOGGER.debug(inter.toString());
                break;
            case 3:
                List<UresoHymAptitud> apt = hyMAptitudDAO.findByIdUsuario(us);
                json = procesarResultadosAptitudes(apt);
                LOGGER.debug(apt.toString());
                break;
            default:
                LOGGER.debug("no se encontr{o examen");
                break;
        }
        return json;
    }
    
    private Map<String, Object> procesarResultadosIntereses( List<UresoHymInteres> intereses){
        
        
        Map<String, Object> valores = new HashMap<>();
        ArrayList<Long> interesesValores = new ArrayList<>();
        ArrayList<String> interesesLables = new ArrayList<>();
        ArrayList<String> interesesColores = new ArrayList<>();
        LOGGER.debug("PROCESSANDO INTERESES");
        for(UresoHymInteres interes : intereses){
            
            
            CatResultadoHerreraymontes cat = resHyMDAO.findOne(interes.getIdCatHym().getIdCatHym());
            long valor = Math.round(((double)interes.getNValor() / 24.0) * 100.0);
            if(valor < 26){
                interesesColores.add("#FF1700");
            }else if (valor < 51){
                interesesColores.add("#D8D651");
            }else if (valor < 76){
                interesesColores.add("#597D3E");
            }else {
                interesesColores.add("#3047A9");
            }
            interesesValores.add(valor);
            interesesLables.add(cat.getCNombre());
            
        }
        valores.put("data", interesesValores);
        valores.put("series", "Perfil Intereses");
        valores.put("labels", interesesLables);
        valores.put("colors", interesesColores);
        
        return valores;
    }
    
    
    private Map<String, Object> procesarResultadosAptitudes(List<UresoHymAptitud> aptitudes){
        LOGGER.debug("PROCESSANDO APTITUDES");
        Map<String, Object> valores = new HashMap<>();
        
        ArrayList<Long> aptitudesValores = new ArrayList<>();
        ArrayList<String> aptitudesLables = new ArrayList<>();
        ArrayList<String> aptitudesColores = new ArrayList<>();
        for(UresoHymAptitud aptitud : aptitudes){
            
            
            CatResultadoHerreraymontes cat = resHyMDAO.findOne(aptitud.getIdCatHym().getIdCatHym());
            long valor = Math.round(((double)aptitud.getNValor() / 24.0) * 100.0);
            if(valor < 26){
                aptitudesColores.add("#FF1700");
            }else if (valor < 51){
                aptitudesColores.add("#D8D651");
            }else if (valor < 76){
                aptitudesColores.add("#597D3E");
            }else {
                aptitudesColores.add("#3047A9");
            }
            
            aptitudesValores.add(valor);
            aptitudesLables.add(cat.getCNombre());
            
        }
        valores.put("data", aptitudesValores);
        valores.put("series", "Perfil Aptitudes");
        valores.put("labels", aptitudesLables);
        valores.put("colors", aptitudesColores);
        return valores;
    }
    
    
    
}
