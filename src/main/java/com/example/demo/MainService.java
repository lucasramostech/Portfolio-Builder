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
    public List<Double> calcularTudo(double capitalTotal, double aporteMensal, List<Ativos> ativos, List<Porcentagens> porcentagens) {
        List<Double> feedbackList = new java.util.ArrayList<>();

        List<Ativo> ativosBanco = ativoRepository.findAll();

        for (int i = 0; i < ativos.size(); i++) {
            Ativo ativo = ativosBanco.get(i);
            List<Double> variations = ativo.getVariacoes();

            // Ponderação do peso 
            double ponderacao = porcentagens.get(i).getPorcentagem() / 100.0;

            for (int n = 0; n < ativosBanco.size(); n++) {

                // Juros compostos

                double variacao = variations.get(n) / 100.0;
                capitalTotal *= (1 + variacao * ponderacao);
                

                // Aportes
                capitalTotal += aporteMensal * ponderacao;

                // Feedback
                feedbackList.add(capitalTotal);

                
    
            }
        }
        return feedbackList;
    }
    
}
