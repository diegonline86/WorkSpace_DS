package com.salesianostriana.ad.contadorletrasporpalabra;

import java.util.concurrent.Callable;


public class ContadorLetras implements Callable<Integer> {
    private String palabra;

    public ContadorLetras(String _palabra){
        palabra = _palabra;
    }

    @Override
    public Integer call() throws Exception {
        return palabra.length();
    }


}
