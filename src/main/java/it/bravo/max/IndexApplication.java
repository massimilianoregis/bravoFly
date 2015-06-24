package it.bravo.max;

import it.bravo.max.index.Index;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * @author max
 * spring boot startup class
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class IndexApplication extends SpringBootServletInitializer {
	
	@Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IndexApplication.class);
		}
	
   public static void main(String[] args) {
       ConfigurableApplicationContext ctx =SpringApplication.run(IndexApplication.class, args);       
   }
}
