package ru.techlab.rest.appservices.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.techlab.rest.appservices.model.LoanQualityCategory;

/**
 * Created by rb052775 on 05.10.2017.
 */
@Repository
@Cacheable("loanQualityCategoryRepository")
public interface LoanQualityCategoryRepository extends CassandraRepository<LoanQualityCategory, String> {

}