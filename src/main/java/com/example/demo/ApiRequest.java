package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ApiRequest {

    // Chave secreta >?
    @Value("${twelve-data.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${app.tickers.fixos}")
    private List<String> tickers;

    // Função que puxa os dados da API twelve data
    public void buscarHistoricoMensal() {

        for (int i = 0; i < tickers.size(); i++) {

            try {
                String url = String.format(
                    "https://api.twelvedata.com/time_series?symbol=%s&interval=1month&outputsize=5000&apikey=%s",
                    tickers.get(i),
                    this.apiKey
                );

                String response = restTemplate.getForObject(url, String.class);
                System.out.println(response);

            } catch (Exception e) {
                System.err.println("Erro ao buscar ticker: " + tickers.get(i));
                e.printStackTrace();
            }

        }

    }
}