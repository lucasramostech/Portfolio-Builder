package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.List;


// Classe que atualiza os dados no banco de dados 30seg
@Component
public class UpScheduled {

    private final SalvarDados salvarDados;
    private final ApiRequest apiRequest;

    @Value("${app.tickers.fixos}")
    private List<String> tickers;

    private int indiceAtual = 0;

    public UpScheduled(SalvarDados salvarDados, ApiRequest apiRequest) {
        this.salvarDados = salvarDados;
        this.apiRequest = apiRequest;
    }

    // Método que executa a cd 1x por dia
    @Scheduled(fixedRate = 86400000) 
    public void atualizarDatabase() {

        if (tickers == null || tickers.isEmpty()) {
            return;
        }
        String tickerAtual = tickers.get(indiceAtual);

        try {
            Map<String, Object> historico = apiRequest.buscarHistoricoMensal(tickerAtual);

            if (historico != null) {
                salvarDados.salvarHistoricoMensal(historico);
            }

            System.out.println("Processado com sucesso (" + (indiceAtual + 1) + "/" + tickers.size() + "): " + tickerAtual);
        } catch (Exception e) {
            System.err.println("Erro ao processar o ticker " + tickerAtual + ": " + e.getMessage());
        }
        indiceAtual = (indiceAtual + 1) % tickers.size();
    }
}

