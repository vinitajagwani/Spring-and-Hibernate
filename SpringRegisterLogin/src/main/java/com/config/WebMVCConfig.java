package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.DAO.UserDAO;
import com.DAO.UserDAOImplementation;

@Configuration
@EnableWebMvc
@ComponentScan("com.controller")
public class WebMVCConfig {
	@Bean
	InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;
	}
	@Bean
	DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mvcregister");
		ds.setUsername("root");
		ds.setPassword("root@123");
		return ds;
	}
	@Bean
	public UserDAO getUserDAO() {
		return new UserDAOImplementation(getDataSource());
	}
}
