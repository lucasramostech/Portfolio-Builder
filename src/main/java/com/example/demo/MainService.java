package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class MainService {


    private final AtivoRepository ativoRepository;


    public MainService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    // Método principal do software
    public List<Feedback> calcularTudo(double capitalInicial, double aporteMensal, List<Ativos> ativos, List<Porcentagens> porcentagens) {
        List<Feedback> feedbackList = new java.util.ArrayList<>();

        List<Ativo> ativosBanco = ativoRepository.findAll();

        for (int i = 0; i < ativos.size(); i++) {
            for (int n = 0; n < ativosBanco.size(); n++) {
                Ativo ativo = ativosBanco.get(n);
                List<Double> variations = ativo.getVariacoes();
            }
        }
        return feedbackList;
    }
    
}
