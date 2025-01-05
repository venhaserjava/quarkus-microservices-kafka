package com.tecnopar.message;

import com.tecnopar.dto.ProposalDTO;
import com.tecnopar.dto.QuotationDTO;
import com.tecnopar.service.OpportunityService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaEvent {
    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Inject
    OpportunityService opportunityService;

    @Incoming("proposal")
    @Transactional
    public void receiveProposal(ProposalDTO proposal){
        LOG.info("-- Recebendo Nova Proposata do Tópico Kafka");
        opportunityService.buildOpportunity(proposal);
    }

    @Incoming("quotation")
    @Blocking
    public void  receiveQuotation(QuotationDTO quotation) {
        LOG.info("-- Recebendo Nova Cotação de Moeda Topico Kafka --");
        opportunityService.saveQuotation(quotation);
    }
}
