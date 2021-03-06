
package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Term {

    @SerializedName("offset")
    @Expose
    private long offset;
    @SerializedName("value")
    @Expose
    private String value;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Term() {
    }

    /**
     * 
     * @param value
     * @param offset
     */
    public Term(long offset, String value) {
        this.offset = offset;
        this.value = value;
    }

    /**
     * 
     * @return
     *     The offset
     */
    public long getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(long offset) {
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }


}
