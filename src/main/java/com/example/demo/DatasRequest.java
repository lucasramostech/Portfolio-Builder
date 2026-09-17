package com.example.demo;
import java.util.List;
import java.util.Map;

public class DatasRequest {

    // Atributos (recebem o front kka)
    private double capitalInicial;
    private double aporteMensal;
    private String tempoEscala;
    private List<Map<String, Object>> ativos;


    // Getter e settters
    public double getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(double capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public double getAporteMensal() {
        return aporteMensal;
    }

    public void setAporteMensal(double aporteMensal) {
        this.aporteMensal = aporteMensal;
    }

    public String getTempoEscala() {
        return tempoEscala;
    }

    public void setTempoEscala(String tempoEscala) {
        this.tempoEscala = tempoEscala;
    }

    public List<Map<String, Object>> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Map<String, Object>> ativos) {
        this.ativos = ativos;
    }


    
}
