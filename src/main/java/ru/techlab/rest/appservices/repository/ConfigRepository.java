package ru.techlab.rest.appservices.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.techlab.rest.appservices.model.BaseConfig;

import java.util.Optional;

/**
 * Created by rb052775 on 05.10.2017.
 */
@Repository
@Cacheable("configRepository")
public interface ConfigRepository extends CassandraRepository<BaseConfig, String> {
    Optional<BaseConfig> findFirstById(Integer id);
}
