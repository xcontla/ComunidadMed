/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.unam.dgoae.instrumentos.dao.InterpreHyMADAO;
import mx.unam.dgoae.instrumentos.dao.InterpreHyMIDAO;
import mx.unam.dgoae.instrumentos.entity.CatInterpreHyma;
import mx.unam.dgoae.instrumentos.entity.CatInterpreHymi;
import mx.unam.dgoae.instrumentos.services.InterpretacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author UNAM
 */
public class InterpretacionServiceImpl implements InterpretacionService{

    private final static Logger LOGGER = LoggerFactory.getLogger(InterpretacionServiceImpl.class);
    
    @Autowired
    private InterpreHyMIDAO ihmidao;
    
    @Autowired
    private InterpreHyMADAO hyMADAO;
    
    
    @Override
    public Map<String, Object> interpretacionInteres(String acronimo) {
        CatInterpreHymi inter = ihmidao.findByCAcronimo(acronimo);
        Map<String, Object> json = new HashMap<>();
        
        json.put("acronimo", inter.getCAcronimo());
        json.put("nombre", inter.getCNombre());
        json.put("profesiones",inter.getCProfesiones());
        json.put("interpretacion",inter.getCInterpretacion());
       return json;
    }

    @Override
    public Map<String, Object> interpretacionAptitud(String acronimo) {
        CatInterpreHyma inter = hyMADAO.findByCAcronimo(acronimo);
        Map<String, Object> json = new HashMap<>();
        json.put("acronimo", inter.getCAcronimo());
        json.put("nombre", inter.getCNombre());
        json.put("profesiones",inter.getCProfesiones());
        json.put("interpretacion",inter.getCInterpretacion());
        return json;
    }
    
}
