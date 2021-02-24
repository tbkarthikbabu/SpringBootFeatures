package dev.boot.features.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public OpenEntityManagerInViewFilter userOpenEntityManagerInViewFilter() {
		OpenEntityManagerInViewFilter oemiFilter = new OpenEntityManagerInViewFilter();
		oemiFilter.setEntityManagerFactoryBeanName("userEntityManagerFactory");
		return oemiFilter;
	}

}
