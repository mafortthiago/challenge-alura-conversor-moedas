package com.mafort.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


public class Conversor {
    public BigDecimal converter(String moedaOrigem, String moedaDesejada, BigDecimal valor) throws IOException, InterruptedException {
        Requisitador requisitador = new Requisitador();
        String json = requisitador.requisicao("https://v6.exchangerate-api.com/v6/2d6e3d4d27e2b7e1d3afb890/latest/"+ moedaOrigem);
        Gson gson = new Gson();
        Moeda moeda = new Moeda(gson.fromJson(json, RecordMoeda.class));
        System.out.println(moeda.converterPara(moedaDesejada,valor));
        return moeda.converterPara(moedaDesejada,valor);
    }
}
