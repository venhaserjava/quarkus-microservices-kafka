package com.tecnopar.controller;


import com.tecnopar.dto.ProposalDetailsDTO;
import com.tecnopar.service.ProposalService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Path("/api/proposal")
public class ProposalController {
    private final Logger LOG = LoggerFactory.getLogger(ProposalController.class);

    @Inject
    ProposalService proposalService;

    @GET
    @Path("/{id}")
    public ProposalDetailsDTO findDetailsProposal(@PathParam("id") Long id){
        return proposalService.findFullProposal(id);
    }
    @POST
    //@RolesAllowed("proposal-customer")
    public Response createProposal(ProposalDetailsDTO proposalDetails){

        LOG.info("--- Recebendo Proposta de Compra ---");
        try {
            proposalService.createNewProposal(proposalDetails);
            return  Response.ok().build();

        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("/{id}")
//    @RolesAllowed("manager")
    public Response removeProposal(@PathParam("id") Long id){
        try {
            proposalService.removeProposal(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }
}
