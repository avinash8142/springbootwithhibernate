package com.web.restfulwebservices;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource(value="boot_${name}.properties")
public class Config {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	Environment env;
	
	 @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	        sessionFactory.setDataSource(datasource);
	        sessionFactory.setPackagesToScan(new String[] {"com.web"});
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
	        hibernateProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
	        sessionFactory.setHibernateProperties(hibernateProperties);
	        return sessionFactory;
	    }
	 
	 @Bean
	    public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager txManager = new HibernateTransactionManager();
	        txManager.setSessionFactory(sessionFactory().getObject());
	        System.out.println("session factory "+sessionFactory().getObject());
	        return txManager;
	    }

}
