package com.tecnopar.repository;

import com.tecnopar.entity.QuotationEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuotationRepository  implements PanacheRepository<QuotationEntity> {
}
