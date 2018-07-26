/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.unam.dgoae.instrumentos.dto.DatosRespuestas;
import mx.unam.dgoae.instrumentos.dto.DatosResultados;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;
import mx.unam.dgoae.instrumentos.services.ExamenPreguntaService;
import mx.unam.dgoae.instrumentos.services.InterpretacionService;
import mx.unam.dgoae.instrumentos.services.UsuarioExamenService;
import mx.unam.dgoae.instrumentos.services.UsuarioRespuestaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author XavierContla
 */
@Controller
@RequestMapping("/usuario/home.dgoae/hym")
public class HyMController {

    public static final Logger LOGGER = LoggerFactory.getLogger(HyMController.class);
    
    @Autowired
    private ExamenPreguntaService examenPreguntaService;

    @Autowired
    private UsuarioRespuestaService usuarioRespuestaService;
    
    @Autowired
    private  UsuarioExamenService examenService;
    
    @Autowired
    private InterpretacionService interpretacionService;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getName(Principal user) {

        Map<String, Object> json = new HashMap<>();
        json.put("username", user.getName());
        return json;
    }
    
    @RequestMapping(value = "/herreraYmontesInfo", method = RequestMethod.GET)
    public String herreraYmontesInfo() {
        return "/usuario/partials/hym/herreraYmontesInfo";
    }
    
    @RequestMapping(value = "/hymInstrucciones", method = RequestMethod.GET)
    public String hymInstrucciones() {
        return "/usuario/partials/hym/hymInstrucciones";
    }

    @RequestMapping(value = "/hymAptitudesInstrucciones", method = RequestMethod.GET)
    public String hymAptitudesInstrucciones() {
        return "/usuario/partials/hym/aptitudes/aptitudesInstrucciones";
    }

    @RequestMapping(value = "/hymInteresesInstrucciones", method = RequestMethod.GET)
    public String hymInteresesInstrucciones() {
        return "/usuario/partials/hym/intereses/interesesInstrucciones";
    }

    @RequestMapping(value = "/hymAptitudes", method = RequestMethod.GET)
    public String hymAptitudes() {
        return "/usuario/partials/hym/aptitudes/aptitudes";
    }

    @RequestMapping(value = "/hymIntereses", method = RequestMethod.GET)
    public String hymIntereses() {
        return "/usuario/partials/hym/intereses/intereses";
    }

    @RequestMapping(value = "/finalHerreraYmontes", method = RequestMethod.GET)
    public String finalHerreraYmontes() {
        return "/usuario/partials/hym/finalHerreraYmontes";
    }
    
   
    
    @RequestMapping(value = "/getExamenByIds/ide/{idExamen}/idp/{idParte}/ids/{idSeccion}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getExamenes(
            @PathVariable(value = "idExamen") int idExamen,
            @PathVariable(value = "idParte") int idParte,
            @PathVariable(value = "idSeccion") int idSeccion) {
    
            LOGGER.debug("examenes: " + idExamen +"  "+ idParte +"  "+ idSeccion);
            return examenPreguntaService.getPreguntasFromIds(idExamen, idParte, idSeccion);
    }
    
    @RequestMapping(value = "/saveHyMAnswersByExamenId", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> saveHyMAnswersByExamenId(@RequestBody List<DatosRespuestas> datos, Principal user) throws ParseException {
        
        UsuarioExamen ue = examenPreguntaService.getUsuarioExamen(datos.get(0), user.getName());
        
        Map<String, Object> json = new HashMap<>();
        json.put("location", "/myHome");
        
        if(ue == null)
            return json;
        
        String respuesta = usuarioRespuestaService.savePreguntas(datos, ue);
        json.put("perfil", respuesta);
        json.put("location", "/aptitudesInstrucciones");
        return json;
    }
    
    @RequestMapping(value = "/getResultados", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getResultados(@RequestBody DatosResultados datos, Principal user) throws ParseException {
        
        LOGGER.debug(datos.toString());
        
        Map<String, Object> resultados = examenService.getResultadosByUsuarioExamen(datos.getIdSeccion(), user.getName());
        
        LOGGER.debug(resultados.toString());
        
        Map<String, Object> json = new HashMap<>();
        json.put("location", "/myHome");
        json.put("res", resultados);
        return json;
    }
    
    @RequestMapping(value = "/getInterpretacionInteres/interes/{interes}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getInterpretacionInteres(
            @PathVariable(value = "interes") String interes,
            Principal user) throws ParseException {
        
        return interpretacionService.interpretacionInteres(interes);
    }

     @RequestMapping(value = "/getInterpretacionAptitud/aptitud/{aptitud}", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getInterpretacionAptitud(
            @PathVariable(value = "aptitud") String aptitud,
            Principal user) throws ParseException {
        
        return interpretacionService.interpretacionAptitud(aptitud);
    }
}
