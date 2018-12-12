package it.edu.microservices.traductor.proxy.environment;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:bootstrap.yml", ignoreResourceNotFound = false) 
@ComponentScan(basePackageClasses = {
		 
		 })
public class QuoteTestConfiguration {

	public QuoteTestConfiguration() {
	}
		

	
	@Bean
	@Primary
	public DataSource dataSource() {
		return null;
	}



	
	
}