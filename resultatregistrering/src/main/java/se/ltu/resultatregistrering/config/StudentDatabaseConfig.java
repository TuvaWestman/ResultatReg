/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package se.ltu.resultatregistrering.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import org.springframework.transaction.PlatformTransactionManager;

import se.ltu.resultatregistrering.model.Student;

import java.util.Map;

@Configuration
@EnableJpaRepositories(
    basePackages = "se.ltu.resultatregistrering.repository.studentits",
    entityManagerFactoryRef = "studentEntityManagerFactory",
    transactionManagerRef = "studentTransactionManager"
)
public class StudentDatabaseConfig {

    // 1. Läs inställningarna från application.properties

@Bean(defaultCandidate = false)
@ConfigurationProperties("app.datasource.studentits")
public DataSourceProperties studentDataSourceProperties() {
    return new DataSourceProperties();
}


    // 2. Skapa anslutningen till studentits_db
    @Bean(name = "studentDataSource", defaultCandidate = false)
    public HikariDataSource studentDataSource(
            @Qualifier("studentDataSourceProperties")
            DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    // 3. Koppla Student-modellen till databasen
    @Bean(name = "studentEntityManagerFactory", defaultCandidate = false)
    public LocalContainerEntityManagerFactoryBean studentEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("studentDataSource")
            HikariDataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages(Student.class)
                .persistenceUnit("studentits")
                .properties(Map.of("hibernate.hbm2ddl.auto", "none"))
                .build();
    }

    // 4. Hantera databastransaktioner
    @Bean(name = "studentTransactionManager", defaultCandidate = false)
    public PlatformTransactionManager studentTransactionManager(
            @Qualifier("studentEntityManagerFactory")
            EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
