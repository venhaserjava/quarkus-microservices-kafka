package com.tecnopar.service;

import com.tecnopar.repository.QuotationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class QuotationService {

    @Inject
    QuotationRepository quotationRepository;

}
