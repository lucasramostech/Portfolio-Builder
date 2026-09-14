package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UpScheduled {

    private final SalvarDados salvarDados;
    private final ApiRequest apiRequest;

    public UpScheduled(SalvarDados salvarDados, ApiRequest apiRequest) {
        this.salvarDados = salvarDados;
        this.apiRequest = apiRequest;
    }

    @Scheduled(cron = "0 0 2 * * *")
    public void atualizarDatabase() {


        Map<String, Object> historico = apiRequest.buscarHistoricoMensal();
        salvarDados.salvarHistoricoMensal(historico);



    }
    
}
