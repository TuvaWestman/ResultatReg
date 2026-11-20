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

import se.ltu.resultatregistrering.model.CanvasAssignment;
import se.ltu.resultatregistrering.model.CanvasGrade;

import java.util.Map;

@Configuration
@EnableJpaRepositories(
    basePackages = "se.ltu.resultatregistrering.repository.canvas",
    entityManagerFactoryRef = "canvasEntityManagerFactory",
    transactionManagerRef = "canvasTransactionManager"
)
public class CanvasDatabaseConfig {

    // 1. Läs databasinställningarna
    @Bean(defaultCandidate = false)
    @ConfigurationProperties("app.datasource.canvas")
    public DataSourceProperties canvasDataSourceProperties() {
        return new DataSourceProperties();
    }

    // 2. Skapa anslutning till canvas_db
    @Bean(name = "canvasDataSource", defaultCandidate = false)
    public HikariDataSource canvasDataSource(
            @Qualifier("canvasDataSourceProperties")
            DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    // 3. Koppla Canvas-modellerna till databasen
    @Bean(name = "canvasEntityManagerFactory", defaultCandidate = false)
    public LocalContainerEntityManagerFactoryBean canvasEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("canvasDataSource")
            HikariDataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages(CanvasAssignment.class, CanvasGrade.class)
                .persistenceUnit("canvas")
                .properties(Map.of("hibernate.hbm2ddl.auto", "none"))
                .build();
    }

    // 4. Hantera Canvas-transaktioner
    @Bean(name = "canvasTransactionManager", defaultCandidate = false)
    public PlatformTransactionManager canvasTransactionManager(
            @Qualifier("canvasEntityManagerFactory")
            EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}