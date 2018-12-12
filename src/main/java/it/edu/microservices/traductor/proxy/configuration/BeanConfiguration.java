package it.edu.microservices.traductor.proxy.configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class BeanConfiguration {

	
	
	private final static Logger LOGGER = LogManager.getLogger(BeanConfiguration.class);

	

	@Bean(name = "versionProperties")
	public Properties gitProperties() {
		LOGGER.info("CREATE VERSION Properties.. ");
		Properties properties = new Properties();
		try {
			properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("/git.properties"));
		} catch (FileNotFoundException e) {
			LOGGER.info("Git properties file not found .. ");
		} catch (IOException e) {
			LOGGER.info("Git properties file problems .. ");
		}
		return properties;
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
	
//  @Bean
//  @LoadBalanced
  public RestTemplate restTemplate() {
      return new RestTemplate();
  }
}
