package com.toy.server.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by ghq on 2018/4/29.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "jsfEntityManagerFactory",
        transactionManagerRef = "jsfTransactionManager", basePackages = {"com.toy.server.dao.jsf"})
public class JsfDataSourceConfig {

    @Autowired
    @Qualifier("jsfDataSource")
    private DataSource jsfDataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "jsfEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean jsfEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(jsfDataSource)
                .properties(getProperties())
                .packages("com.toy.server.entity.jsf")
                .build();
    }

    @Bean(name = "jsfTransactionManager")
    public PlatformTransactionManager jsfTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(jsfEntityManagerFactory(builder).getObject());
    }

//    @Bean(name = "jsfEntityManager")
//    public EntityManager jsfEntityManager(EntityManagerFactoryBuilder builder) {
//        return jsfEntityManagerFactory(builder)
//                .getObject()
//                .createEntityManager();
//    }

    public Map<String, Object> getProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }
}
