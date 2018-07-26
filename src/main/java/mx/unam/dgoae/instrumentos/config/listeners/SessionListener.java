/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.config.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author XavierContla
 */
public class SessionListener implements HttpSessionListener{

    
    public static final Logger LOGGER = LoggerFactory.getLogger(SessionListener.class);
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOGGER.debug("SESSION CREATE");
        se.getSession().setMaxInactiveInterval(2100);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LOGGER.debug("SESSION DESTOYED");
    }
    
    
    
}
