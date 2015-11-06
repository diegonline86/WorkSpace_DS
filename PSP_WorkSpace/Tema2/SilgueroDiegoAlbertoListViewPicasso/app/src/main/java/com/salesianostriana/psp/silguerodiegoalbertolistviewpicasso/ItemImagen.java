package com.salesianostriana.psp.silguerodiegoalbertolistviewpicasso;

/**
 * Created by das on 06/11/2015.
 */
public class ItemImagen {
    private String nombreImagen;
    private int imgRsrc;

    public ItemImagen(String nombreImagen, int imgRsrc) {
        this.nombreImagen = nombreImagen;
        this.imgRsrc = imgRsrc;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public int getImgRsrc() {
        return imgRsrc;
    }

    public void setImgRsrc(int imgRsrc) {
        this.imgRsrc = imgRsrc;
    }

}
