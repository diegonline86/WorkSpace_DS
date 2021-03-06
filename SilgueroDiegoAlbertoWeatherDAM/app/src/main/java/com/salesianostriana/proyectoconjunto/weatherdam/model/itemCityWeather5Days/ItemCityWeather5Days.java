
package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCityWeather5Days;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class ItemCityWeather5Days {

    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private double message;
    @SerializedName("cnt")
    @Expose
    private long cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = new ArrayList<List>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemCityWeather5Days() {
    }

    /**
     * 
     * @param message
     * @param cnt
     * @param cod
     * @param list
     * @param city
     */
    public ItemCityWeather5Days(City city, String cod, double message, long cnt, java.util.List<List> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    /**
     * 
     * @return
     *     The city
     */
    public City getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     * 
     * @param cod
     *     The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * 
     * @return
     *     The message
     */
    public double getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(double message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The cnt
     */
    public long getCnt() {
        return cnt;
    }

    /**
     * 
     * @param cnt
     *     The cnt
     */
    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    /**
     * 
     * @return
     *     The list
     */
    public java.util.List<List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    public void setList(java.util.List<List> list) {
        this.list = list;
    }



}
