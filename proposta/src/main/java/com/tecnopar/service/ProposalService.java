package com.tecnopar.service;

import com.tecnopar.dto.ProposalDetailsDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ProposalService {

    ProposalDetailsDTO findFullProposal(Long id);

    void createNewProposal(ProposalDetailsDTO proposalDetailsDTO);

    void removeProposal(Long id);

}
