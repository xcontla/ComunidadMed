/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.config.handlers;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author UNAM
 */
@Component
public class UNAMUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
    
    
    public static final Logger LOGGER = LoggerFactory.getLogger(UNAMUrlAuthenticationSuccessHandler.class);

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) throws IOException, ServletException {
        handle(hsr,hsr1,a);
        clearAuthenticationAttributes(hsr);
    }
    
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication)
      throws IOException {
  
        
        String targetUrl;
 
       // Poner las ipque quieren que se ingrese
        /*String ipAddress = request.getRemoteAddr();
        System.out.println(ipAddress);
        System.out.println(!ipAddress.substring(0,8).equalsIgnoreCase("132.248."));
        if(!ipAddress.substring(0,8).equalsIgnoreCase("132.248.")){
            //targetUrl = "/accessDenied.dgoae";
            targetUrl = "/perform_logout";
            LOGGER.debug("No está dentro de la UNAM");
            
        }
        else*/
            targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            LOGGER.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        LOGGER.debug("Targer URL" + targetUrl);
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    protected String determineTargetUrl(Authentication authentication) {
        boolean isUser = false;
        boolean isAdmin = false;
        Collection<? extends GrantedAuthority> authorities
         = authentication.getAuthorities();
        LOGGER.debug("authorities" + authorities);
        for (GrantedAuthority grantedAuthority : authorities) {
            
            LOGGER.debug("Authority ????" + grantedAuthority.getAuthority());
            if (grantedAuthority.getAuthority().equals("ROLE_USUARIO")) {
                isUser = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }
        
        if (isUser) {
            return "/usuario/home.dgoae";
        } else if (isAdmin){
            return "/admin/admin.dgoae";
        }
        else {
            throw new IllegalStateException();
        }
    }
 
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    
}
