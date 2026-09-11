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

    // Função que puxa os dados da API twelve data
    public String buscarHistoricoMensal(List<Map<String, Object>> ativos) {

        for (int i = 0; i < ativos.size(); i++) {
            String url = String.format(
            "https://api.twelvedata.com/time_series?symbol=%s&interval=1month&outputsize=5000&apikey=%s",
            ativos.get(i).get("ticker"),
            this.apiKey
        );

        }
        

        // Tratamento de erros
        try {

            return restTemplate.getForObject(url, String.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}