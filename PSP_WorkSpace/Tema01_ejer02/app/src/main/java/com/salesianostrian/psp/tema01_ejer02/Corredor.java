package com.salesianostrian.psp.tema01_ejer02;

import android.util.Log;

public class Corredor extends Thread {
    //Atributos
    private String nombre;

    //Constructor
    public Corredor(String _nombre){
        nombre = _nombre;
    }

    //Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            Log.i(nombre,"¡Ha salido!");
            //avanzamos de 10 en 10
            for (int i=0; i<=1500; i+=10) {
                Log.d(nombre, i + "m");
                Thread.sleep(10);
            }
            Log.i(nombre, "¡Ha finalizado la prueba!");} catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
