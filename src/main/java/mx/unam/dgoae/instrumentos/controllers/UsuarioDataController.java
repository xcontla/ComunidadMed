/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.controllers;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.unam.dgoae.instrumentos.dto.DatosRespuestas;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;
import mx.unam.dgoae.instrumentos.services.UsuarioExamenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author XavierContla
 */
@Controller
@RequestMapping("/usuario/home.dgoae/data")
public class UsuarioDataController {

    public static final Logger LOGGER = LoggerFactory.getLogger(UsuarioDataController.class);

    @Autowired
    private UsuarioExamenService usuarioExamenService;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getName(Principal user) {

        Map<String, Object> json = new HashMap<>();
        json.put("username", user.getName());
        return json;
    }

    @RequestMapping(value = "/getExamenes", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getExamenes(Principal user) {

        List<UsuarioExamen> examenes = usuarioExamenService.getExamenByUsernameAndIdExamen(user.getName(), 1);

        Map<String, Object> json = new HashMap<>();

        json.put("username", user.getName());
        json.put("size", examenes.size());
        if (examenes.size() > 1) {
            json.put("existe", true);
        } else {
            json.put("existe", false);
        }

        List<Map<String, Object>> array = new ArrayList();
        for (UsuarioExamen ue : examenes) {
            Map<String, Object> examen = new HashMap<>();
            examen.put("idExamen", ue.getIdExamen().getIdExamen());
            examen.put("idParte", ue.getIdParte().getIdParte());
            examen.put("idSeccion", ue.getIdSeccion().getIdSeccion());
            examen.put("fechaAplicacion", (new SimpleDateFormat("yyyy-MM-dd").format(ue.getDCreacion())));
            array.add(examen);
        }
        json.put("examenes", array);
        return json;
    }

}
