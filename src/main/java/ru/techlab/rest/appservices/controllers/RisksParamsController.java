package ru.techlab.rest.appservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.techlab.rest.appservices.model.LoanQualityCategory;
import ru.techlab.rest.appservices.model.LoanServCoeff;
import ru.techlab.rest.appservices.repository.LoanQualityCategoryMatrixRepository;
import ru.techlab.rest.appservices.repository.LoanQualityCategoryRepository;
import ru.techlab.rest.appservices.repository.LoanServCoeffRepository;
import ru.xegex.risks.libs.model.quality.LoanQualityCategoryMatrix;

/**
 * Created by rb052775 on 05.10.2017.
 */
@RestController
@RequestMapping("/risksparams")
@CrossOrigin(value = "http://localhost:8222")
public class RisksParamsController {
    @Autowired
    private LoanQualityCategoryRepository loanQualityCategoryRepository;
    @Autowired
    private LoanServCoeffRepository loanServCoeffRepository;

    @Autowired
    private LoanQualityCategoryMatrixRepository loanQualityCategoryMatrixRepository;

    @RequestMapping(value = "/loanqualitycategories", method = RequestMethod.GET)
    public Iterable<LoanQualityCategory> getAllLoanQualityCategories(){
        return loanQualityCategoryRepository.findAll();
    }

    @RequestMapping(value = "/loanservcoeffs", method = RequestMethod.GET)
    public Iterable<LoanServCoeff> getLoanServCoeffs(){
        return loanServCoeffRepository.findAll();
    }

    @RequestMapping(value = "/loanservcoeffsmatrix", method = RequestMethod.GET)
    public Iterable<LoanQualityCategoryMatrix> getLoanQualityCategoryMatrix(){
        return loanQualityCategoryMatrixRepository.findAll();
    }
}
