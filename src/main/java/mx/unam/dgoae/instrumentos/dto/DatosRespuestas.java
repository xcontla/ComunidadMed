/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dto;

/**
 *
 * @author XavierContla
 */

// <!-- {'pExId':pregunta.preguntaExamenId,'pid':pregunta.preguntaId,'oid':opcion.opcionId,'oidx':opcion.opcionIndice , 'acronimo': acronimo}-->
public class DatosRespuestas {
    
    private Long preguntaExamenId;
    private Long preguntaId;
    private Long opcionId;
    private String opcionIndice;
    private Integer idExamen;
    private String acronimo;

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }
    
    public Long getPreguntaExamenId() {
        return preguntaExamenId;
    }

    public void setPreguntaExamenId(Long preguntaExamenId) {
        this.preguntaExamenId = preguntaExamenId;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Long getOpcionId() {
        return opcionId;
    }

    public void setOpcionId(Long opcionId) {
        this.opcionId = opcionId;
    }

    public String getOpcionIndice() {
        return opcionIndice;
    }

    public void setOpcionIndice(String opcionIndice) {
        this.opcionIndice = opcionIndice;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    @Override
    public String toString() {
        return "DatosRespuestas[ ExamenID:"+ this.getIdExamen() +","+ "preguntaExamenId: "+ this.getPreguntaExamenId()+"]"
                + "::[ PreguntaId: " + this.getPreguntaId()+", OpcionId: "+ this.getOpcionId()+ ",OpcionIndice: " +this.getOpcionIndice() + ",Acronimo: " + this.getAcronimo() +" ]";
    }

    
}
