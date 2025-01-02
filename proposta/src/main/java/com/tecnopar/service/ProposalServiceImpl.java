package com.tecnopar.service;

import com.tecnopar.dto.ProposalDTO;
import com.tecnopar.dto.ProposalDetailsDTO;
import com.tecnopar.entity.ProposalEntity;
import com.tecnopar.message.KafkaEvent;
import com.tecnopar.repository.ProposalRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Date;

@ApplicationScoped
public class ProposalServiceImpl  implements ProposalService{

    @Inject
    ProposalRepository proposalRepository;

//    @Inject
//    KafkaEvent kafkaMessages;

    @Override
    public ProposalDetailsDTO findFullProposal(Long id) {
        ProposalEntity proposal = proposalRepository.findById(id);

        return  ProposalDetailsDTO.builder()
                .proposalId(proposal.getId())
                .proposalValidityDays(proposal.getProposalValidityDays())
                .country(proposal.getCountry())
                .priceTonne(proposal.getPriceTonne())
                .customer(proposal.getCustomer())
                .tonnes(proposal.getTonnes())
                .build();
    }

    @Override
    @Transactional
    public void createNewProposal(ProposalDetailsDTO proposalDetailsDTO) {

        ProposalDTO proposal = buildAndSaveNewProposal(proposalDetailsDTO);
//        kafkaMessages.sendNewKafkaEvent(proposal);

    }

    @Transactional
    public ProposalDTO buildAndSaveNewProposal(ProposalDetailsDTO proposalDetailsDTO) {
        try {
            ProposalEntity proposal = new ProposalEntity();

            proposal.setCreated(new Date());
            proposal.setProposalValidityDays(proposalDetailsDTO.getProposalValidityDays());
            proposal.setCountry(proposalDetailsDTO.getCountry());
            proposal.setCustomer(proposalDetailsDTO.getCustomer());
            proposal.setPriceTonne(proposalDetailsDTO.getPriceTonne());
            proposal.setTonnes(proposal.getTonnes());

            proposalRepository.persist(proposal);;

            return  ProposalDTO.builder()
                    .proposalId(proposalRepository.findByCustomer(proposalDetailsDTO.getCustomer()).get().getId())
                    .priceTonne(proposal.getPriceTonne())
                    .customer(proposal.getCustomer())
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public void removeProposal(Long id) {
       proposalRepository.deleteById(id);
    }
}
