package com.tecnopar.service;

import com.tecnopar.dto.OpportunityDTO;
import com.tecnopar.dto.ProposalDTO;
import com.tecnopar.dto.QuotationDTO;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface OpportunityService {
        void buildOpportunity(ProposalDTO proposal);

        void saveQuotation(QuotationDTO quotation);

        List<OpportunityDTO> generateOpportunityData();
}
