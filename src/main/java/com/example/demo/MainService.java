package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;


@Service
public class MainService {


    private final AtivoRepository ativoRepository;


    public MainService(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    // Método principal do software
    public List<Double> calcularTudo(double capitalTotal, double aporteMensal, List<Map<String, Object>> ativos) {
        List<Double> feedbackList = new java.util.ArrayList<>();

        List<Ativo> ativosBanco = ativoRepository.findAll();

        int quantidadePeriodos = ativosBanco.get(0).getVariacoes().size();

        for (int n = 0; n < quantidadePeriodos; n++) {
            double retornoPonderado = 0.0;

            for (int i = 0; i < ativos.size(); i++) {
                Ativo ativo = ativosBanco.get(i);
                double ponderacao = Double.parseDouble(String.valueOf(ativos.get(i).get("percentual"))) / 100.0;
                double variacao = ativo.getVariacoes().get(n) / 100.0;

                retornoPonderado += variacao * ponderacao;
            }

            capitalTotal *= (1 + retornoPonderado);
            capitalTotal += aporteMensal;
            feedbackList.add(capitalTotal);
        }
        return feedbackList;
    }
    
}
