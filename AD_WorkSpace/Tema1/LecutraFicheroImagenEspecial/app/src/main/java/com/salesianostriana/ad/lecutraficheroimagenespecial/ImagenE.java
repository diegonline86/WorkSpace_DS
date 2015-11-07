package com.salesianostriana.ad.lecutraficheroimagenespecial;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diego on 14/10/2015.
 */
public class ImagenE {
    private int codigo, ancho, alto;
    private String comentario;
    List<Byte> contenido;

    public ImagenE(int codigo,  String comentario, int ancho, int alto, byte contenido) {
        this.codigo = codigo;
        this.ancho = ancho;
        this.alto = alto;
        this.comentario = comentario;
        this.contenido = new ArrayList<>();
        this.contenido.add(contenido);
    }

    //Getters y setters
    public int getCodigo() {

        return codigo;
    }

    public void setCodigo(int codigo) {

        this.codigo = codigo;
    }

    public int getAncho() {

        return ancho;
    }

    public void setAncho(int ancho) {

        this.ancho = ancho;
    }

    public int getAlto() {

        return alto;
    }

    public void setAlto(int alto) {

        this.alto = alto;
    }

    public String getComentario() {

        return comentario;
    }

    public void setComentario(String comentario) {

        this.comentario = comentario;
    }

    public List<Byte> getContenido() {

        return contenido;
    }

    public void setContenido(List<Byte> contenido) {

        this.contenido = contenido;
    }
}
