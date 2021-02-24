package dev.boot.features.data.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "dev.boot.features.data.user.repositories", entityManagerFactoryRef = "userEntityManagerFactory", transactionManagerRef = "userTransactionManager")
public class UserDataSourceConfig {

	@Autowired
	private Environment env;

	@Bean
	@ConfigurationProperties(prefix = "datasource.user")
	public DataSourceProperties userDataSourceProperty() {

		return new DataSourceProperties();
	}

	/**
	 * 
	 * Pattern: create the datasource object using the Builder Design Pattern
	 * 
	 * @return
	 */
	@Bean
	public DataSource userDataSource() {

		DataSourceProperties userDataSourceProperty = userDataSourceProperty();
		return DataSourceBuilder.create().driverClassName(userDataSourceProperty.getDriverClassName())
				.url(userDataSourceProperty.getUrl()).username(userDataSourceProperty.getUsername())
				.password(userDataSourceProperty.getPassword()).build();

	}

	@Bean
	public PlatformTransactionManager userTransactionManager() {

		EntityManagerFactory factory = userEntityManagerFactory().getObject();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean userEntityManagerFactory() {

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(userDataSource());
		factory.setPackagesToScan(new String[] { "dev.boot.features.data.user.entities" });
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		jpaProperties.put("hibernate.show-sql", env.getProperty("spring.jpa.show-sql"));
		factory.setJpaProperties(jpaProperties);

		return factory;
	}

	@Bean
	public DataSourceInitializer userDataSourceInitializer() {
		DataSourceInitializer datasourceInitializer = new DataSourceInitializer();
		datasourceInitializer.setDataSource(userDataSource());
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("user-data.sql"));
		datasourceInitializer.setDatabasePopulator(databasePopulator);
		datasourceInitializer.setEnabled(env.getProperty("datasource-user.initialize", Boolean.class, false));
		return datasourceInitializer;
	}
}
