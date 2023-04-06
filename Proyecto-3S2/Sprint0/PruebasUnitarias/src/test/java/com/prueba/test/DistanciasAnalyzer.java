package com.prueba.test;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class DistanciasAnalyzer {

    @Test
    void Origen() {
        var distancia = new Distancia();
        var punto = new Coordenada(0,0);
        double resultado = distancia.calcularDistancia(punto);
        assertThat(resultado).isEqualTo(0);
    }

    @Test
    void PrimerCuadrante() {
        var distancia = new Distancia();
        var punto = new Coordenada(3,4);
        var resultado = distancia.calcularDistancia(punto);
        assertThat(resultado,5);

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
