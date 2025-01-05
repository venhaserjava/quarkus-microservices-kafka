package com.tecnopar.service;

import com.tecnopar.dto.OpportunityDTO;
import com.tecnopar.dto.ProposalDTO;
import com.tecnopar.dto.QuotationDTO;
import com.tecnopar.entity.OpportunityEntity;
import com.tecnopar.entity.QuotationEntity;
import com.tecnopar.repository.OpportunityRepository;
import com.tecnopar.repository.QuotationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class OpportunityServiceImpl implements OpportunityService{

    @Inject
    QuotationRepository quotationRepository;
    @Inject
    OpportunityRepository opportunityRepository;

    @Override
    public void buildOpportunity(ProposalDTO proposal) {
        List<QuotationEntity> quotationEntities = quotationRepository.findAll().list();
        Collections.reverse(quotationEntities);

        OpportunityEntity opportunity = new OpportunityEntity();
        opportunity.setDate(new Date());
        opportunity.setProposal(proposal.getProposalId());
        opportunity.setCustomer(proposal.getCustomer());
        opportunity.setPriceTonne(proposal.getPriceTonne());
        opportunity.setLastDollarQuotation(quotationEntities.get(0).getCurrencyPrice());
        opportunityRepository.persist(opportunity);
    }

    @Override
    public void saveQuotation(QuotationDTO quotation) {

    }

    @Override
    public List<OpportunityDTO> generateOpportunityData() {
        return List.of();
    }
}
