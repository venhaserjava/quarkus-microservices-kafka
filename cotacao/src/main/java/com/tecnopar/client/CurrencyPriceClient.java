package com.tecnopar.client;

import com.tecnopar.dto.CurrencyPriceDTO;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/last")
//@RegisterRestClient(baseUri = "https://economia.awesomeapi.com.br/json")
@RegisterRestClient
@ApplicationScoped
public interface CurrencyPriceClient {
    @GET
    @Path("/{pair}")
    CurrencyPriceDTO getPriceByPair(@PathParam("pair") String pair);
}
