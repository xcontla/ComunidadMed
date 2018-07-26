/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.dgoae.instrumentos.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import mx.unam.dgoae.instrumentos.services.ExamenPreguntaService;
import mx.unam.dgoae.instrumentos.services.InterpretacionService;
import mx.unam.dgoae.instrumentos.services.LoginService;
import mx.unam.dgoae.instrumentos.services.LoginRoleService;
import mx.unam.dgoae.instrumentos.services.UsuarioExamenService;
import mx.unam.dgoae.instrumentos.services.UsuarioRespuestaService;
import mx.unam.dgoae.instrumentos.services.impl.ExamenPreguntaServiceImpl;
import mx.unam.dgoae.instrumentos.services.impl.InterpretacionServiceImpl;
import mx.unam.dgoae.instrumentos.services.impl.LoginServiceImpl;
import mx.unam.dgoae.instrumentos.services.impl.LoginRoleServiceImpl;
import mx.unam.dgoae.instrumentos.services.impl.UsuarioExamenServiceImpl;
import mx.unam.dgoae.instrumentos.services.impl.UsuarioRespuestaServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author UNAM
 */
@EnableJpaRepositories(basePackages = {"mx.unam.dgoae.instrumentos.dao"})
@Configuration
public class ApplicationContext {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContext.class);
    
    
    @Bean
    public LoginService loginService(){return new LoginServiceImpl();}
    
    
    @Bean
    public LoginRoleService loginRoleService(){return new LoginRoleServiceImpl();}
    
    
    @Bean
    public ExamenPreguntaService examenPreguntaService() {return new ExamenPreguntaServiceImpl();}
    
    
    @Bean
    public  UsuarioRespuestaService usuarioRespuestaService(){return new UsuarioRespuestaServiceImpl();}
    
    @Bean
    public UsuarioExamenService usuarioExamenService(){return new UsuarioExamenServiceImpl();}
    
    @Bean
    public InterpretacionService interpretacionService(){return new InterpretacionServiceImpl();};
    
    @Autowired
    private Environment enviroment;
    
    
    @Bean
    public DataSource dataSource(){
        LOGGER.debug(":dataSource() -> creating BEAN dataSource");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(enviroment.getProperty("jdbc.driverClass"));
        dataSource.setUrl(enviroment.getProperty("jdbc.url"));
        dataSource.setUsername(enviroment.getProperty("jdbc.username"));
        dataSource.setPassword(enviroment.getProperty("jdbc.password"));
        return dataSource;
    }
    
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
    
        LOGGER.debug(":transactionManager() -> creating BEAN transactionManager");
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
    
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        LOGGER.debug(":jpaVendorAdapter() -> creating BEAN jpaVendorAdapter");
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        
        return hibernateJpaVendorAdapter;
                
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LOGGER.debug(":LocalContainerEntityManagerFactoryBean() -> creating BEAN entityMananger");
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("mx.unam.dgoae.instrumentos.entity");
        return entityManagerFactoryBean;
    }
}
