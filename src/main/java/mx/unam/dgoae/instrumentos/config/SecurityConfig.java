/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.config;

import javax.sql.DataSource;
import mx.unam.dgoae.instrumentos.config.handlers.UNAMUrlAuthenticationSuccessHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author UNAM
 */
@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = {"mx.unam.dgoae.instrumentos"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @Autowired
    private UNAMUrlAuthenticationSuccessHandler uNAMUrlAuthenticationSuccessHandler;
    
    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        LOGGER.debug("Authentication from JDBC");
        
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .passwordEncoder(bCryptPasswordEncoder);
        
    }
    
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        //super.configure(web); //To change body of generated methods, choose Tools | Templates.
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //uper.configure(http); //To change body of generated methods, choose Tools | Templates.
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/*",
                        "/init/**",
                        "/chagenPassword",
                        "/login.dgoae*", 
                        "/perform_login",
                        "/change_pass",
                        "/out.dgoae").permitAll()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/usuario/**").hasRole("USUARIO")
                .anyRequest().authenticated()
            .and()
                .formLogin()
                    .successHandler(uNAMUrlAuthenticationSuccessHandler)//.usernameParameter("loginuname").passwordParameter("loginpass")
                    .loginPage("/login.dgoae")
                    .loginProcessingUrl("/perform_login")
                    //.defaultSuccessUrl("/usuario/myHome.dgoae")
                    .failureUrl("/out.dgoae")
                .and()
                    .logout()
                    .logoutUrl("/perform_logout")
                    .logoutSuccessUrl("/login.dgoae")
                .and()
                    .exceptionHandling().accessDeniedPage("/out.dgoae")
                .and()
                    .sessionManagement().maximumSessions(1)
                    .expiredUrl("/login.dgoae");
    }

}
