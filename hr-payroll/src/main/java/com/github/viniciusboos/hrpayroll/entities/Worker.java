package com.github.viniciusboos.hrpayroll.entities;

import java.io.Serializable;

public class Worker implements Serializable {
    private static final long serialVersionUID= 1l;

    private Long id;
    private String nome;
    private Double dailyIncome;

    public Worker(Long id, String nome, Double dailyIncome) {
        this.id = id;
        this.nome = nome;
        this.dailyIncome = dailyIncome;
    }

    public Worker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }
}
