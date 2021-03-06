package ru.techlab.rest.appservices.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;
import ru.techlab.rest.appservices.model.LoanQualityResult;

import java.util.stream.Stream;

/**
 * Created by dim777 on 05.10.17.
 */
@Repository
@Cacheable("loanQualityResultRepository")
public interface LoanQualityResultRepository extends CassandraRepository<LoanQualityResult, String> {
    @Query("SELECT * FROM SRRU WHERE RRABD = ?0 AND RRAND = ?1 AND RRASD = ?2")
    Stream<LoanQualityResult> findSimpleDelayByLoan(String branch, String loanAccountNumber, String loanAccountSuffix);

    @Query("SELECT * from kks_results")
    Slice<LoanQualityResult> findAllPaged(Pageable pageable);

    Slice<LoanQualityResult> findAllByLoanAccountNumber(String loanAccountNumber, Pageable pageable);
}
