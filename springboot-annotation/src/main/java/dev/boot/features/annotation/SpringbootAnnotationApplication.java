package dev.boot.features.annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import dev.boot.features.annotation.service.UserService;

/**
 * 
 * @SpringBootApplication = @Configuration + @ComponentScan
 *                        + @EnableAutoConfiguration
 * 
 *
 *
 *                        1. To enable Java -based configuration 2. To enable
 *                        component scanning, scanning all the classes under
 *                        this package without specify the package structure 3.
 *                        To enable Spring boot auto-configuration features
 * 
 * @author karth
 *
 */
@SpringBootApplication
public class SpringbootAnnotationApplication {

	private static Logger LOG = LoggerFactory.getLogger(SpringbootAnnotationApplication.class);

	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		ApplicationContext context = SpringApplication.run(SpringbootAnnotationApplication.class, args);
		UserService user = context.getBean(UserService.class);
		user.processMsg("SMS");
		LOG.info("APPLICATION FINISHED");
	}

}
