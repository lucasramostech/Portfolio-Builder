package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class SalvarDados {

    // Invocamos a var de repository 
    private final AtivoRepository ativoRepository;


    public SalvarDados(AtivoRepository ativoRepository) {
        this.ativoRepository = ativoRepository;
    }

    @Transactional

    public void salvarHistoricoMensal(Map<String, Object> historicoGeral) {

        // Array dos variations
        List<AtivoVariactionEntity> entidadesParaSalvar = new ArrayList<>();

        // Loops para pegar as info necessárias 

        historicoGeral.forEach((ticker, conteudo) -> {
        Map<String, Object> ativoData = (Map<String, Object>) conteudo;
        List<Map<String, Object>> values = (List<Map<String, Object>>) ativoData.get("values");

        if (values != null && values.size() > 1) {
            List<Double> variacoes = new ArrayList<>();

            // Percorre em ordem cronológica inversa
            for (int i = values.size() - 1; i > 0; i--) {
                double precoAnterior = Double.parseDouble(values.get(i).get("close").toString());
                double precoAtual = Double.parseDouble(values.get(i - 1).get("close").toString());

                double variacaoPercentual = ((precoAtual - precoAnterior) / precoAnterior) * 100;
                variacoes.add(Math.round(variacaoPercentual * 100.0) / 100.0); // Arredonda para 2 casas
            }

            // Instancia seu objeto mais as variations
            AtivoVariactionEntity entidade = new AtivoVariactionEntity(ticker, variacoes);
            entidadesParaSalvar.add(entidade);
        }
    });

    ativoRepository.saveAll(entidadesParaSalvar);

}




    
}
