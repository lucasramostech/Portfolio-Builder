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
        public ResultadoInvestimento calcularTudo(double capitalTotal, double aporteMensal, String tempoEscala,List<Map<String, Object>> ativos) {
        
        // Listas e variaveis 
        List<Double> feedbackList = new java.util.ArrayList<>();
        double capitalInicial = capitalTotal;
        List<Ativo> ativosBanco = ativoRepository.findAll();
        List<Ativo> ativosCalculados = new java.util.ArrayList<>();

        for (Map<String, Object> ativoRequest : ativos) {
            String ticker = String.valueOf(ativoRequest.get("ticker"));

            if ("Fixed-Rate".equalsIgnoreCase(ticker)) {
                continue;
            }
            
            Ativo ativo = ativosBanco.stream()
                .filter(ativoBanco -> ticker.equals(ativoBanco.getTicker()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                    "Ativo não encontrado: " + ticker));

            ativosCalculados.add(ativo);
        }
    

        // O historico disponivel e o periodo escolhido definem o tamanho da simulacao.
        int menorPeriodo = Integer.MAX_VALUE;

        for (int x = 0; x < ativosCalculados.size(); x++) {

            List<Double> tamanhoVariacoes = ativosCalculados.get(x).getVariacoes();
            if (tamanhoVariacoes.size() < menorPeriodo) {
                menorPeriodo = tamanhoVariacoes.size();
            }
        }

        // Verificação para o período escolhido pelo user
        int periodoEscolhido = switch (tempoEscala) {
            case "3" -> 36;
            case "5" -> 60;
            case "7" -> 84;
            case "10" -> 120;
            default -> Integer.MAX_VALUE;
        };

        if (menorPeriodo == Integer.MAX_VALUE) {
            menorPeriodo = periodoEscolhido == Integer.MAX_VALUE ? 120 : periodoEscolhido;
        } else {
            menorPeriodo = Math.min(menorPeriodo, periodoEscolhido);
        }

        List<List<Double>> variacoesRecentes = new java.util.ArrayList<>();

        // Laço padrão percorrendo os ativos escolhidos
        for (Map<String, Object> ativoRequest : ativos) {
            String ticker = String.valueOf(ativoRequest.get("ticker"));
            List<Double> ultimasVariacoes;

            // Renda fixa caso tenha
            if ("Fixed-Rate".equalsIgnoreCase(ticker)) {
                double taxaAnual = Double.parseDouble(
                    String.valueOf(ativoRequest.get("taxaAnual")));
                double taxaMensal = Math.pow(1 + taxaAnual / 100.0, 1.0 / 12.0) - 1.0;
                ultimasVariacoes = java.util.Collections.nCopies(
                    menorPeriodo, taxaMensal * 100.0);
            } else {
                Ativo ativo = ativosCalculados.remove(0);
                List<Double> variacoes = ativo.getVariacoes();
                int inicio = variacoes.size() - menorPeriodo;
                ultimasVariacoes = new java.util.ArrayList<>(
                    variacoes.subList(inicio, variacoes.size()));
            }

            variacoesRecentes.add(ultimasVariacoes);
        }


        double[] saldoAtivos = new double[ativos.size()];
        for (int acao = 0; acao < ativos.size(); acao++) {
            double ponderacao = Double.parseDouble(
                String.valueOf(ativos.get(acao).get("percentual"))) / 100.0;
            saldoAtivos[acao] = capitalTotal * ponderacao;
        }

        // Juros com rebalançeamento por padrao aqui 
        for (int mes = 0; mes < menorPeriodo; mes++) {

            double novoCapitalTotal = 0.0;

            for (int acao = 0; acao < ativos.size(); acao++) {
                double ponderacao = Double.parseDouble(String.valueOf(ativos.get(acao).get("percentual"))) / 100.0;
                double variacao = variacoesRecentes.get(acao).get(mes) / 100.0;

                saldoAtivos[acao] *= (1 + variacao);
                saldoAtivos[acao] += aporteMensal * ponderacao;
                novoCapitalTotal += saldoAtivos[acao];
            }
            capitalTotal = novoCapitalTotal;
            feedbackList.add(capitalTotal);
        }


        //Calcular total investido e multiplicador de capital
        double totalInvestido = capitalInicial + (aporteMensal * menorPeriodo);
        double multiplicadorCapital = totalInvestido == 0 ? 0 : capitalTotal / totalInvestido;

        // Return do obj para atualizações futuras ficarem mais fácei
        return new ResultadoInvestimento(
            capitalTotal,
            totalInvestido,
            multiplicadorCapital,
            feedbackList
        );
    }
    
}
