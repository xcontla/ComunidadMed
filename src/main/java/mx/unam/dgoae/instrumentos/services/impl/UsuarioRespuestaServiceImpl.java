/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import mx.unam.dgoae.instrumentos.dao.ExamenPreguntaDAO;
import mx.unam.dgoae.instrumentos.dao.OpcionDAO;
import mx.unam.dgoae.instrumentos.dao.PreguntaDAO;
import mx.unam.dgoae.instrumentos.dao.ResHyMDAO;
import mx.unam.dgoae.instrumentos.dao.UserHyMAptitudDAO;
import mx.unam.dgoae.instrumentos.dao.UserHyMInteresDAO;
import mx.unam.dgoae.instrumentos.dao.UsuarioExamenDAO;
import mx.unam.dgoae.instrumentos.dao.UsuarioRespuestaDAO;
import mx.unam.dgoae.instrumentos.dto.DatosRespuestas;
import mx.unam.dgoae.instrumentos.entity.CatResultadoHerreraymontes;
import mx.unam.dgoae.instrumentos.entity.ExamenPregunta;
import mx.unam.dgoae.instrumentos.entity.Opcion;
import mx.unam.dgoae.instrumentos.entity.UresoHymAptitud;
import mx.unam.dgoae.instrumentos.entity.UresoHymInteres;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;
import mx.unam.dgoae.instrumentos.entity.UsuarioRespuesta;
import mx.unam.dgoae.instrumentos.services.UsuarioRespuestaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author UNAM
 */
public class UsuarioRespuestaServiceImpl implements UsuarioRespuestaService{
    

    public static final Logger LOGGER = LoggerFactory.getLogger(UsuarioRespuestaService.class);
    
    
    @Autowired
    private UsuarioRespuestaDAO respuestaDAO;
    
    @Autowired
    private ResHyMDAO hyMDAO;
    
    @Autowired
    private ExamenPreguntaDAO examenPreguntaDAO;

    @Autowired
    private OpcionDAO opcionDAO;
    
    @Autowired
    private UserHyMAptitudDAO aptitudDAO;
    
    @Autowired
    private UserHyMInteresDAO interesDAO;
    
    
    @Override
    public String savePreguntas(List<DatosRespuestas> datos, UsuarioExamen ue) {
        
        List<CatResultadoHerreraymontes> catHym = hyMDAO.findAll();
        int totalInt = catHym.size() - 1;
        int[] resultados = new int[totalInt];
        for (int i = 0; i < totalInt; i++) {
            resultados[i] = 0;
        }
        
        /*Salvando respuestas en tabla*/
        ExamenPregunta epreg;
        
        for (DatosRespuestas dato : datos) {
            epreg = examenPreguntaDAO.findOne(dato.getPreguntaExamenId());
            UsuarioRespuesta ures = new UsuarioRespuesta();
            ures.setIdExamenPregunta(epreg);
            Opcion op = opcionDAO.findOne(dato.getOpcionId());
            ures.setIdOpcion(op);
            ures.setIdUsuarioExamen(ue);
            ures.setDCreacion(new Date());
            ures.setDModificacion(new Date());
            respuestaDAO.saveAndFlush(ures);
            int index = Integer.parseInt(epreg.getCIndice());
            int valor = op.getNValor();
            resultados[((index - 1) % totalInt)] += valor;
        }
        
        /*Salvando resultados a tabla*/
        /**
         * Calificar
         */
        String respuesta = "";
        int seccion = ue.getIdSeccion().getIdSeccion();
        for (CatResultadoHerreraymontes cIn : catHym) {
            switch (seccion) {
                case 2:
                    {
                        if(cIn.getIdCatHym() == 10)
                            break;
                        UresoHymInteres urIn = new UresoHymInteres();
                        urIn.setDAplicacion(new Date());
                        urIn.setIdCatHym(cIn);
                        urIn.setIdUsuario(ue.getIdUsuario());
                        if(cIn.getIdCatHym() == 11)
                            urIn.setNValor(resultados[9]);
                        else
                            urIn.setNValor(resultados[cIn.getIdCatHym() - 1]);
                        
                        urIn.setDCreacion(new Date());
                        urIn.setDModificacion(new Date());
                        interesDAO.saveAndFlush(urIn);
                        respuesta = "intereses";
                        break;
                    }
                case 3:
                    {
                        if(cIn.getIdCatHym() == 11)
                            break;
                        UresoHymAptitud urIn = new UresoHymAptitud();
                        urIn.setDAplicacion(new Date());
                        urIn.setIdCatHym(cIn);
                        urIn.setIdUsuario(ue.getIdUsuario());
                        urIn.setNValor(resultados[cIn.getIdCatHym() - 1]);
                        urIn.setDCreacion(new Date());
                        urIn.setDModificacion(new Date());
                        aptitudDAO.saveAndFlush(urIn);
                        respuesta = "aptitudes";
                        break;
                    }
                default:
                    respuesta = "otra cosa";
                    break;
            }
            
        }
        
        
        return respuesta;
    }
   
    
    
}
