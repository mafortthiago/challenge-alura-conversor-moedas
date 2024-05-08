package com.mafort.controller;

import com.google.gson.Gson;
import com.mafort.model.Moeda;
import com.mafort.model.RecordMoeda;
import com.mafort.model.Requisitador;

import java.io.IOException;
import java.math.BigDecimal;


public class Conversor {
    public BigDecimal converter(String moedaOrigem, String moedaDesejada, BigDecimal valor) throws IOException, InterruptedException {
        String chaveApi = System.getenv("API_CHAVE");
        Requisitador requisitador = new Requisitador();
        String json = requisitador.requisicao("https://v6.exchangerate-api.com/v6/"+ chaveApi+"/latest/"+ moedaOrigem);
        Gson gson = new Gson();
        Moeda moeda = new Moeda(gson.fromJson(json, RecordMoeda.class));
        return moeda.converterPara(moedaDesejada,valor);
    }
}
