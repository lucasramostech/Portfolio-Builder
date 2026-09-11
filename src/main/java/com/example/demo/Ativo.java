package com.example.demo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ativos")
public class Ativo {
    
    // Sempre pensar na estrutura do banco de dados primeiro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticker", length = 10, nullable = false)
    private String ticker;

    @ElementCollection
    @CollectionTable(name = "ativo_variacoes", joinColumns = @JoinColumn(name = "ativo_id"))
    @Column(name = "variacao")
    private List<Double> variacoes;
    

    // Construtor padrão exigido pelo JPA
    public Ativo() {
    }

    // Construtor personalizado 
    public Ativo(String ticker, List<Double> variacoes) {
        this.ticker = ticker;
        this.variacoes = variacoes;
        
    }

    // Getters e Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getTicker() { 
        return ticker; 
    }
    
    public void setTicker(String ticker) { 
        this.ticker = ticker; 
    }

    public List<Double> getVariacoes() { 
        return variacoes; 
    }

    public void setVariacoes(List<Double> variacoes) { 
        this.variacoes = variacoes; 
    }
}