package ru.techlab.rest.appservices.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.xegex.risks.libs.model.quality.LoanQualityCategoryMatrix;

/**
 * Created by rb052775 on 05.10.2017.
 */
@Repository
@Cacheable("loanQualityCategoryMatrixRepository")
public interface LoanQualityCategoryMatrixRepository extends CassandraRepository<LoanQualityCategoryMatrix, String> {
}
