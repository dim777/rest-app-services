package ru.techlab.rest.appservices.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * Created by rb052775 on 02.10.2017.
 */
@Configuration
@ComponentScan(basePackages = { "ru.*" })
@EnableCaching
@EnableCassandraRepositories(basePackages = "ru.techlab.rest.appservices.repository")
public class AppConfig extends AbstractCassandraConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keyspace;
    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;
    @Value("${spring.data.cassandra.port}")
    private Integer port;
    @Value("${spring.data.cassandra.username}")
    private String username;
    @Value("${spring.data.cassandra.password}")
    private String password;

    @Override
    @Bean
    public CassandraClusterFactoryBean cluster() {
        final CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
        cluster.setContactPoints(contactPoints);
        cluster.setPort(port);
        cluster.setUsername(username);
        cluster.setPassword(password);
        LOGGER.info("Cluster started: " + contactPoints + ":" + port + ", keyspace: " + keyspace);
        return cluster;
    }

    /*@Override
    @Bean
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new CassandraMappingContext();
    }*/

    @Override
    protected String getKeyspaceName() {
        return keyspace;
    }
}
