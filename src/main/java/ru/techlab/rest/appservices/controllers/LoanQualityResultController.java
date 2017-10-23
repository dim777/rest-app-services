package ru.techlab.rest.appservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import ru.techlab.rest.appservices.model.LoanQualityResult;
import ru.techlab.rest.appservices.repository.LoanQualityResultRepository;

import java.util.List;

/**
 * Created by dim777 on 05.10.17.
 */
@RestController
@RequestMapping("/loansquality")
@CrossOrigin
public class LoanQualityResultController {
    @Autowired
    private LoanQualityResultRepository loanQualityResultRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<LoanQualityResult> getAll() {
        return loanQualityResultRepository.findAll();
    }

    @RequestMapping(value = "/filter", params = { "$skip", "$top", "$count"}, method = RequestMethod.GET)
    public List<LoanQualityResult> withoutFilter(@RequestParam( "$skip" ) Integer skip, @RequestParam( "$top" ) Integer top,
                                          @RequestParam( "$count" ) Boolean count) {

        Slice<LoanQualityResult> results = loanQualityResultRepository.findAllPaged(CassandraPageRequest.of(skip, top));
        return results.getContent();
    }

    @RequestMapping(value = "/filter", params = { "$skip", "$top", "$count", "$filter" }, method = RequestMethod.GET)
    public List<LoanQualityResult> filter(@RequestParam( "$skip" ) Integer skip, @RequestParam( "$top" ) Integer top,
                                          @RequestParam( "$count" ) Boolean count, @RequestParam( "$filter" ) String filter) {
        Slice<LoanQualityResult> results = loanQualityResultRepository.findAllByLoanAccountNumber("dfdf", CassandraPageRequest.of(skip, top));
        //contains(ProductName,%27ff%27)
        return null;
    }

}
