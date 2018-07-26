/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.services;

import java.util.Map;

/**
 *
 * @author UNAM
 */
public interface InterpretacionService {
    
     Map<String, Object> interpretacionInteres(String acronimo);
     Map<String, Object> interpretacionAptitud(String acronimo);
}
