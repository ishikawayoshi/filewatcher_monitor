package com.ishikawa.fwm.fwmcore.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

@Configuration
@PropertySource(value = "classpath:fwm-core.properties")
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories("com.ishikawa.fwm.fwmcore.repositories")
@Slf4j
public class DataConfiguration {

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Value("${db.driver}")
//    private String DB_DRIVER;

    @Value("${db.url}")
    private String DB_URL;

    @Value("${db.username}")
    private String DB_USERNAME;

    @Value("${db.password}")
    private String DB_PASSWORD;

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.format_sql}")
    private String HIBERNATE_FORMAT_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Value("${hibernate.generate_statistics}")
    private boolean HIBERNATE_GENERATE_STATISTICS;

    @Value("${hibernate.ejb.naming_strategy}")
    private String HIBERNATE_NAMING_STRATEGY;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${db.schema.create}")
    private String DB_CREATE_SCHEMA;

    @Value("${db.users.create}")
    private String DB_CREATE_USERS;

    @Value("${db.populate.data}")
    private String[] DB_POPULATE_DATE;

    @Bean
    @DependsOn("entityManagerFactory")
    public ResourceDatabasePopulator initDatabase(DataSource dataSource) throws Exception {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);
        if (!DB_CREATE_SCHEMA.isEmpty()) {
            log.info("Add {} to populator ", DB_CREATE_SCHEMA);
            populator.addScript(new ClassPathResource(DB_CREATE_SCHEMA));
        }
        if (!DB_CREATE_USERS.isEmpty()) {
            log.info("Add {} to populator ", DB_CREATE_USERS);
            populator.addScript(new ClassPathResource(DB_CREATE_USERS));
        }
        if (DB_POPULATE_DATE != null && DB_POPULATE_DATE.length>0) {
            log.info("Add {} to populator ", Arrays.toString(DB_POPULATE_DATE));
            Arrays.stream(DB_POPULATE_DATE).forEach(script->{
                ClassPathResource script1 = new ClassPathResource(script);
                log.info("Is file {} exists? {} ", script, script1.exists());
                populator.addScript(script1);
            });
        }
        populator.populate(dataSource.getConnection());
        return populator;
    }

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setJdbcUrl(DB_URL);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.ishikawa.fwm.fwmcore");

        Properties jpaProperties = new Properties();
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, HIBERNATE_DIALECT);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, HIBERNATE_FORMAT_SQL);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, HIBERNATE_HBM2DDL_AUTO);
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, HIBERNATE_SHOW_SQL);

        jpaProperties.put("hibernate.implicit_naming_strategy", "com.ishikawa.fwm.fwmcore.config.CustomImplicitNamingStrategy");
        jpaProperties.put("hibernate.physical_naming_strategy", "com.ishikawa.fwm.fwmcore.config.ImprovedNamingStrategy");
        jpaProperties.put("hibernate.id.new_generator_mappings", false);
        jpaProperties.put("hibernate.generate_statistics", HIBERNATE_GENERATE_STATISTICS);

        jpaProperties.put("hibernate.jdbc.fetch_size", 400);
        jpaProperties.put("hibernate.jdbc.batch_size", 100);
        jpaProperties.put("hibernate.order_inserts", true);
        jpaProperties.put("hibernate.order_updates", true);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}

