package com.tecnopar.service;

import com.tecnopar.client.CurrencyPriceClient;
import com.tecnopar.dto.CurrencyPriceDTO;
import com.tecnopar.dto.QuotationDTO;
import com.tecnopar.entity.QuotationEntity;
import com.tecnopar.message.KafkaEvents;
import com.tecnopar.repository.QuotationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@ApplicationScoped
public class QuotationService {

    @Inject
    QuotationRepository quotationRepository;

    @Inject
    @RestClient
    CurrencyPriceClient currencyPriceClient;

    @Inject
    KafkaEvents kafkaEvents;

    public void getCurrencyPrice() {

        CurrencyPriceDTO currencyPriceInfo = currencyPriceClient.getPriceByPair("USD-BRL");

        if (updateCurrentInfoPrice(currencyPriceInfo)) {
            kafkaEvents.sendNewKafkaEvent(QuotationDTO
                    .builder()
                    .currencyPrice(new BigDecimal(currencyPriceInfo.getUSDBRL().getBid()))
                    .date(new Date())
                    .build());
        }
    }
    private boolean updateCurrentInfoPrice(CurrencyPriceDTO currencyPriceInfo ) {

        BigDecimal currentPrice = new BigDecimal(currencyPriceInfo.getUSDBRL().getBid());
//        AtomicBoolean updatePrice = new AtomicBoolean(false);
        boolean updatePrice = false;


        List<QuotationEntity> quotationList = quotationRepository.findAll().list();

        if (quotationList.isEmpty()) {
            saveQuotation(currencyPriceInfo);
//            updatePrice.set(true);
            updatePrice = true;
        } else {
            QuotationEntity lastDollarPrice = quotationList
                    .get(quotationList.size() -1);

            if (currentPrice.floatValue()> lastDollarPrice.getCurrencyPrice().floatValue() ) {
//                updatePrice.set(true);
                updatePrice = true;
                saveQuotation(currencyPriceInfo);
            }
        }
//        return  updatePrice.get();
        return updatePrice;
    }

    private void saveQuotation(CurrencyPriceDTO currencyInfo) {
        QuotationEntity quotation = new QuotationEntity();

        quotation.setDate(new Date());
        quotation.setCurrencyPrice(new BigDecimal(currencyInfo.getUSDBRL().getBid()));
        quotation.setPctChange(currencyInfo.getUSDBRL().getPctChange());
        quotation.setPair("USD-BRL");

        try {
            quotationRepository.persist(quotation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
