
package com.salesianostriana.proyectoconjunto.weatherdam.model.itemCity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchedSubstring {

    @SerializedName("length")
    @Expose
    private long length;
    @SerializedName("offset")
    @Expose
    private long offset;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MatchedSubstring() {
    }

    /**
     * 
     * @param length
     * @param offset
     */
    public MatchedSubstring(long length, long offset) {
        this.length = length;
        this.offset = offset;
    }

    /**
     * 
     * @return
     *     The length
     */
    public long getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The length
     */
    public void setLength(long length) {
        this.length = length;
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



}
