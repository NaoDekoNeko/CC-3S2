package com.prueba.test;

import org.junit.jupiter.api.Test;

public class DistanciasAnalyzer {

    @Test
    void Origen() {
        var distancia = new Distancia();
        var punto = new Coordenada(0,0);
        var resultado = distancia.calcularDistancia(punto);
    }

    @Test
    void PrimerCuadrante() {
        var distancia = new Distancia();
        var punto = new Coordenada(3,4);
        var resultado = distancia.calcularDistancia(punto);

    }

    @Test
    void SegundoCuadrante() {
        var distancia = new Distancia();
        var punto = new Coordenada(-3,4);
        var resultado = distancia.calcularDistancia(punto);
        
    }

    @Test
    void TercerCuadrante() {
        var distancia = new Distancia();
        var punto = new Coordenada(-3,-4);
        var resultado = distancia.calcularDistancia(punto);
    }

    @Test
    void CuartoCuadrante() {
        var distancia = new Distancia();
        var punto = new Coordenada(3,-4);
        var resultado = distancia.calcularDistancia(punto);
    }

}
