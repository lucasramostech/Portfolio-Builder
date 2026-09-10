package com.example.demo;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ativos")
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticker", length = 10, nullable = false)
    private String ticker;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "preco", precision = 12, scale = 2, nullable = false)
    private BigDecimal preco;

    // Construtor padrão exigido pelo JPA
    public Ativo() {
    }

    // Construtor personalizado
    public Ativo(String ticker, LocalDate data, BigDecimal preco) {
        this.ticker = ticker;
        this.data = data;
        this.preco = preco;
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

    public LocalDate getData() { 
        return data; 
    }
    
    public void setData(LocalDate data) { 
        this.data = data; 
    }

    public BigDecimal getPreco() { 
        return preco; 
    }
    
    public void setPreco(BigDecimal preco) { 
        this.preco = preco; 
    }
}