package com.salesianostriana.ad.ejemplo_simple_xml;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by das on 18/11/2015.
 */
@Root
public class Example {

    @Element
    private String text;

    @Attribute
    private int index;

    public Example() {
        super();
    }

    public Example(String text, int index) {
        this.text = text;
        this.index = index;
    }

    public String getMessage() {
        return text;
    }

    public int getId() {
        return index;
    }

    @Override
    public String toString() {
        return "Example{" +
                "text='" + text + '\'' +
                ", index=" + index +
                '}';
    }
}
