package com.example.demo;
import java.util.List;
import java.util.Map;

public class DatasRequest {

    // Atributos (recebem o front kka)
    private double capitalInicial;
    private double aporteMensal;
    private int anos;
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

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public List<Map<String, Object>> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Map<String, Object>> ativos) {
        this.ativos = ativos;
    }


    
}
