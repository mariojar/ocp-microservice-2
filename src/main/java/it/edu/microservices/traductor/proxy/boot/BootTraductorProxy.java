package it.edu.microservices.traductor.proxy.boot;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.AbstractEnvironment;

import it.edu.microservices.traductor.proxy.configuration.BeanConfiguration;
import it.edu.microservices.traductor.proxy.utils.UtilHelper;
import it.edu.microservices.traductor.proxy.version.TraductorProxyVersion;




@SpringBootApplication
@ComponentScan(basePackageClasses = {
									 TraductorProxyVersion.class,
									 })
@Import({BeanConfiguration.class})
@EnableAutoConfiguration
public class BootTraductorProxy implements ApplicationContextAware {
	
	private final static Logger LOGGER = LogManager.getLogger(BootTraductorProxy.class);
	
	@Autowired
	@Qualifier("versionProperties") 
	Properties versionProperties;
	
	@Value("${spring.application.name:temporalNameNotEncontre}")
	private String appName;
	
	
	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, UtilHelper.getActiveProfile(args));
		SpringApplication.run(BootTraductorProxy.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
	}
	
	@PostConstruct
	public void printVersion() {
		LOGGER.info("\n\t Deploy Version "+ appName + " \n"+UtilHelper.buildVersionInfo(versionProperties)+". \n\n");
	}
	
}
