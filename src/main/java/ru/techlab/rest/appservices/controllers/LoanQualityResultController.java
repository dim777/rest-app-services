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

    @RequestMapping(value = "/list", params = { "page", "size" }, method = RequestMethod.GET)
    public List<LoanQualityResult> getAll(@RequestParam( "page" ) int page, @RequestParam( "size" ) int size) {
        Slice<LoanQualityResult> results = loanQualityResultRepository.findAllPaged(CassandraPageRequest.of(page, size));
        return results.getContent();
    }

}
