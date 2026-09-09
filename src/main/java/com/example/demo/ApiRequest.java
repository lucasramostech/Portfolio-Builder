package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiRequest {

    // Chave secreta >?
    @Value("${twelve-data.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();


    public String buscarHistoricoMensal(String ticker) {
        String url = String.format(
            "https://api.twelvedata.com/time_series?symbol=%s&interval=1month&apikey=%s",
            ticker,
            this.apiKey
        );

        return restTemplate.getForObject(url, String.class);
    }
}