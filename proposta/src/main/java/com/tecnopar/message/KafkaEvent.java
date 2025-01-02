package com.tecnopar.message;

import com.tecnopar.dto.ProposalDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@ApplicationScoped
public class KafkaEvent {
    private final Logger LOG = LoggerFactory.getLogger(KafkaEvent.class);

    @Channel("proposal")
    Emitter<ProposalDTO> proposalRequestEmitter;

    public void sendNewKafkaEvent(ProposalDTO proposalDTO){
        LOG.info(" -- Enviando Nova Proposta para Tópico Kafka --");
        proposalRequestEmitter.send(proposalDTO).toCompletableFuture().join();
    }

}
