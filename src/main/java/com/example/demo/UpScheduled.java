package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;

import java.util.Map;

@Component
public class UpScheduled {

    private final SalvarDados salvarDados;
    private final ApiRequest apiRequest;

    public UpScheduled(SalvarDados salvarDados, ApiRequest apiRequest) {
        this.salvarDados = salvarDados;
        this.apiRequest = apiRequest;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void carregarDadosAoIniciar() {
        atualizarDatabase();
    }

    @Scheduled(cron = "0 0 2 * * *")
    public void atualizarDatabase() {


        Map<String, Object> historico = apiRequest.buscarHistoricoMensal();
        salvarDados.salvarHistoricoMensal(historico);



    }
    
}
