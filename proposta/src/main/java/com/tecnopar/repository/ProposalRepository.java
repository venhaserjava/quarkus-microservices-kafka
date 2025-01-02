package com.tecnopar.repository;

import com.tecnopar.entity.ProposalEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

//@Slf4j
@ApplicationScoped
public class ProposalRepository implements PanacheRepository<ProposalEntity> {

    public  Optional<ProposalEntity> findByCustomer(String customer) {
        return Optional.of(find("customer",customer).firstResult());
    }

}
