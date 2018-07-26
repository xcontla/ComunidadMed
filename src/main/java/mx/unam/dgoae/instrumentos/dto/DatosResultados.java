/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.dto;


/**
 *
 * @author UNAM
 */
public class DatosResultados {
    
    private Integer idSeccion;
    private Integer idParte;
    private Integer idExamen;
    private String fechaAplicacion;
    

    public DatosResultados() {
    }

    public DatosResultados(Integer idSeccion, Integer idParte, Integer idExamen, String fechaAplicacion) {
        this.idSeccion = idSeccion;
        this.idParte = idParte;
        this.idExamen = idExamen;
        this.fechaAplicacion = fechaAplicacion;
    }
    
    
    
    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public Integer getIdParte() {
        return idParte;
    }

    public void setIdParte(Integer idParte) {
        this.idParte = idParte;
    }

    public Integer getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }
    
    

    
    
    
}
