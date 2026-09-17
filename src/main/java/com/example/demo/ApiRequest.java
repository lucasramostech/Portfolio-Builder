package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


@Component
public class ApiRequest {

    // Chave secreta >?
    @Value("${twelve-data.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    

    // Função que puxa os dados da API twelve data
    public Map<String, Object> buscarHistoricoMensal(String ticker) {

        Map<String, Object> historicoGeral = new HashMap<>();
        
        String tickerAtual = ticker;

        try {
            String url = String.format(
                "https://api.twelvedata.com/time_series?symbol=%s&interval=1month&outputsize=5000&apikey=%s",
                tickerAtual,
                this.apiKey
            );

            Map<String, Object> resultadoAtivo = restTemplate.getForObject(url, Map.class);
            historicoGeral.put(tickerAtual, resultadoAtivo);

        } catch (Exception e) {
            System.err.println("Erro ao buscar ticker: " + tickerAtual);
            e.printStackTrace();
        }

    
    return historicoGeral;
    }
}