/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mx.unam.dgoae.instrumentos.dao.ExamenDAO;
import mx.unam.dgoae.instrumentos.dao.ExamenPreguntaDAO;
import mx.unam.dgoae.instrumentos.dao.LoginDAO;
import mx.unam.dgoae.instrumentos.dao.OpcionDAO;
import mx.unam.dgoae.instrumentos.dao.ParteDAO;
import mx.unam.dgoae.instrumentos.dao.PreguntaDAO;
import mx.unam.dgoae.instrumentos.dao.SeccionDAO;
import mx.unam.dgoae.instrumentos.dao.UsuarioExamenDAO;
import mx.unam.dgoae.instrumentos.dto.DatosRespuestas;
import mx.unam.dgoae.instrumentos.dto.DatosResultados;
import mx.unam.dgoae.instrumentos.entity.ExamenPregunta;
import mx.unam.dgoae.instrumentos.entity.Login;
import mx.unam.dgoae.instrumentos.entity.Opcion;
import mx.unam.dgoae.instrumentos.entity.Pregunta;
import mx.unam.dgoae.instrumentos.entity.UsuarioExamen;
import mx.unam.dgoae.instrumentos.services.ExamenPreguntaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author UNAM
 */
public class ExamenPreguntaServiceImpl implements ExamenPreguntaService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExamenPreguntaServiceImpl.class);

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private ExamenPreguntaDAO examenPreguntaDAO;

    @Autowired
    private PreguntaDAO preguntaDAO;

    @Autowired
    private OpcionDAO opcionDAO;

    @Autowired
    private ExamenDAO examenDAO;

    @Autowired
    private ParteDAO parteDAO;

    @Autowired
    private SeccionDAO seccionDAO;

    @Autowired
    private UsuarioExamenDAO usuarioExamenDAO;

    @Override
    public Map<String, Object> getPreguntasFromIds(Integer examen, Integer parte, Integer seccion) {
        Map<String, Object> pg = new HashMap<>();
        LOGGER.debug("EXAMEN: " + examen + ", parte: " + parte + ", seccion: " + seccion);
        List<ExamenPregunta> examenPreguntas = examenPreguntaDAO.findByIdExamenAndIdParteAndIdSeccion(examenDAO.findOne(examen), parteDAO.findOne(parte), seccionDAO.findOne(seccion));
        LOGGER.debug("Tamaño de las preguntas" + examenPreguntas.size());
        ArrayList<Map<String, Object>> pregArray = new ArrayList<>();
        for (ExamenPregunta exaPreg : examenPreguntas) {
            Map<String, Object> infopreg = new HashMap<>();
            String indice = exaPreg.getCIndice();
            infopreg.put("preguntaIndice", indice);
            infopreg.put("preguntaExamenId", exaPreg.getIdExamenPregunta());
            List<Pregunta> preguntas = preguntaDAO.findByIdExamenPreguntaAndBStatus(exaPreg, true);///
            for (Pregunta preg : preguntas) {
                infopreg.put("preguntaId", preg.getIdPregunta());
                infopreg.put("preguntaTipo", preg.getIdTipoDato().getIdTipoDato());
                switch (preg.getIdTipoDato().getIdTipoDato()) {

                    case 1:
                        infopreg.put("preguntaTexto", preg.getCPregunta().trim());
                        break;
                    case 2:
                        infopreg.put("preguntaArchivo", preg.getPreguntaImagen().getCNombreArchvio());
                        break;
                    case 3:
                        infopreg.put("preguntaTexto", preg.getCPregunta().trim());
                        infopreg.put("preguntaArchivo", preg.getPreguntaImagen().getCNombreArchvio());
                        break;
                    default:
                        infopreg.put("preguntaTexto", null);
                        infopreg.put("preguntaArchivo", null);
                }

                List<Opcion> opciones = opcionDAO.findByIdExamenPreguntaAndBStatus(exaPreg, true);
                ArrayList<Map<String, Object>> opArray = new ArrayList();
                for (Opcion op : opciones) {
                    Map<String, Object> infoOp = new HashMap<>();
                    String indiceOp;
                    indiceOp = op.getCPosIndice();
                    infoOp.put("opcionId", op.getIdOpcion());
                    infoOp.put("opcionIndice", indiceOp);
                    infoOp.put("opcionTipo", op.getIdTipoDato().getIdTipoDato());
                    switch (op.getIdTipoDato().getIdTipoDato()) {
                        case 1:
                            infoOp.put("opcionTexto", op.getCOpcion());
                            break;
                        case 2:
                            infoOp.put("opicionArchivo", op.getOpcionImagen().getCNombreArchvio());
                            break;
                        case 3:
                            infoOp.put("opTexto", op.getCOpcion());
                            infoOp.put("opicionArchivo", op.getOpcionImagen().getCNombreArchvio());
                            break;
                        default:
                            infoOp.put("opTexto", null);
                            infoOp.put("opArchivo", null);
                    }
                    opArray.add(infoOp);//meter la opcion en el array
                }
                infopreg.put("opciones", opArray);
                infopreg.put("respuesta", "");
            }
            pregArray.add(infopreg);

        }
        pg.put("preguntas", pregArray);
        return pg;
    }

    @Override
    public UsuarioExamen getUsuarioExamen(DatosRespuestas dato, String username) {

        ExamenPregunta epreg = examenPreguntaDAO.findOne(dato.getPreguntaExamenId());
        Login us = loginDAO.findByCCurp(username);
        if (us != null) {
            UsuarioExamen ue = new UsuarioExamen();
            ue.setIdUsuario(us);
            ue.setIdExamen(epreg.getIdExamen());
            ue.setIdParte(epreg.getIdParte());
            ue.setIdSeccion(epreg.getIdSeccion());
            ue.setDCreacion(new Date());
            ue.setDModificacion(new Date());
            usuarioExamenDAO.saveAndFlush(ue);

            return ue;
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

}
