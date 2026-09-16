package com.example.demo;

import java.util.List;

public class ResultadoInvestimento {

    // Atribuots
    private double capitalTotal;
    private double totalInvestido;
    private double multiplicadorCapital;
    private List<Double> evolucaoFeedBack;

    
    // Construtor 
    public ResultadoInvestimento(double capitalTotal, double totalInvestido, double multiplicadorCapital, List<Double> evolucaoFeedBack) {
        this.capitalTotal = capitalTotal;
        this.totalInvestido = totalInvestido;
        this.multiplicadorCapital = multiplicadorCapital;
        this.evolucaoFeedBack = evolucaoFeedBack;
    }



    // Getters e Setters
    public double getCapitalTotal() {
        return capitalTotal;
    }

    public double getTotalInvestido() {
        return totalInvestido;
    }

    public double getMultiplicadorCapital() {
        return multiplicadorCapital;
    }

    public List<Double> getEvolucaoFeedBack() {
        return evolucaoFeedBack;
    }

    public void setCapitalTotal(double capitalTotal) {
        this.capitalTotal = capitalTotal;
    }

    public void setTotalInvestido(double totalInvestido) {
        this.totalInvestido = totalInvestido;
    }

    public void setMultiplicadorCapital(double multiplicadorCapital) {
        this.multiplicadorCapital = multiplicadorCapital;
    }

    public void setEvolucaoFeedBack(List<Double> evolucaoFeedBack) {
        this.evolucaoFeedBack = evolucaoFeedBack;
    }
    
}
