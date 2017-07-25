package com.project.shopping_Backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({ "classpath:online-shopping.properties" })
@ComponentScan(basePackages = { "com.project.shopping_Backend" })
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "master.db.url";
	private final static String DATABASE_DRIVER = "jdbc.driverClassName";
	private final static String DATABASE_DIALECT = "hibernate.dialect";
	private final static String DATABASE_USERNAME = "master.db.user";
	private final static String DATABASE_PASSWORD = "master.db.pass";

	private final static String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private final static String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";

	@Autowired
	private Environment env;

	@Bean
	@Primary
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty(DATABASE_DRIVER));
		dataSource.setUrl(env.getProperty(DATABASE_URL));
		dataSource.setUsername(env.getProperty(DATABASE_USERNAME));
		dataSource.setPassword(env.getProperty(DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	@Primary
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder factoryBuilder = new LocalSessionFactoryBuilder(dataSource);
		factoryBuilder.addProperties(getHibernateProperties());
		factoryBuilder.scanPackages("com.project.shopping_Backend");
		return factoryBuilder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty(DATABASE_DIALECT));
		properties.put("hibernate.show_sql", env.getProperty(HIBERNATE_SHOW_SQL));
		properties.put("hibernate.format_sql", env.getProperty(HIBERNATE_FORMAT_SQL));

		return properties;
	}

	@Bean
	@Primary
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
