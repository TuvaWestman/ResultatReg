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

import se.ltu.resultatregistrering.model.Result;
import se.ltu.resultatregistrering.model.RegistrationLog;

import java.util.Map;

@Configuration
@EnableJpaRepositories(
    basePackages = "se.ltu.resultatregistrering.repository.ladok",
    entityManagerFactoryRef = "ladokEntityManagerFactory",
    transactionManagerRef = "ladokTransactionManager"
)
public class LadokDatabaseConfig {

    // 1. Läs inställningarna från application.properties

@Bean(defaultCandidate = false)
@ConfigurationProperties("app.datasource.ladok")
public DataSourceProperties ladokDataSourceProperties() {
    return new DataSourceProperties();
}


    // 2. Skapa anslutningen till ladok_db
    @Bean(name = "ladokDataSource", defaultCandidate = false)
    public HikariDataSource ladokDataSource(
            @Qualifier("ladokDataSourceProperties")
            DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    // 3. Koppla LADOK-modellerna till databasen
    @Bean(name = "ladokEntityManagerFactory", defaultCandidate = false)
    public LocalContainerEntityManagerFactoryBean ladokEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("ladokDataSource")
            HikariDataSource dataSource) {

        return builder
                .dataSource(dataSource)
                .packages(Result.class, RegistrationLog.class)
                .persistenceUnit("ladok")
                .properties(Map.of("hibernate.hbm2ddl.auto", "none"))
                .build();
    }

    // 4. Hantera transaktioner
    @Bean(name = "ladokTransactionManager", defaultCandidate = false)
    public PlatformTransactionManager ladokTransactionManager(
            @Qualifier("ladokEntityManagerFactory")
            EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
