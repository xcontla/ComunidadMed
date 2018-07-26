/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import mx.unam.dgoae.instrumentos.config.listeners.SessionListener;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author UNAM
 */
public class WebAppInitializer implements WebApplicationInitializer{
    
    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebConfig.class);
        
        sc.addListener(new ContextLoaderListener(webApplicationContext));
        sc.addListener(new SessionListener());
       
        DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
        
        DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
        //dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic reDynamic = sc.addServlet("dispatcherServlet", dispatcherServlet);
        
        sc.addFilter("springSecurityFilterChain", filter).addMappingForUrlPatterns(null, true, "/*");
        
        reDynamic.setLoadOnStartup(1);
        reDynamic.addMapping("/");
    }
    
}
