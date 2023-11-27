package com.example.nuevaprueba.enums;

public enum Carreras {

    Electronica("IngenieriaElectronica"),
    Mecanica("IngenieriaMecanica"),
    Ingreso("Ingreso");

    private String valor;
    Carreras(String valor) {
        this.valor=valor;
    }
    public String getValorAsociado() {
        return valor;
    }
}
