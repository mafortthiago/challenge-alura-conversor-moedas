package com.mafort.model;
import java.math.BigDecimal;
import java.util.HashMap;

public class Moeda {
    private String nome;
    private HashMap<String, BigDecimal> valores;

    public Moeda(RecordMoeda rmoeda){
        this.nome = rmoeda.base_code();
        this.valores = rmoeda.conversion_rates();
    }
    public BigDecimal converterPara(String moeda, BigDecimal valor){
        return this.valores.get(moeda).multiply(valor);
    }
}
