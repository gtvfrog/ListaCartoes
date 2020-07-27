package com.teste.data.model;

import java.io.Serializable;

public class Categoria implements Serializable {
    private final String type;
    private final String background_color;
    private final String image_path;

    public Categoria(String type, String background_color, String image_path) {
        this.type = type;
        this.background_color = background_color;
        this.image_path = image_path;
    }

    public String getType() {
        return type;
    }

    public String getBackground_color() {
        return background_color;
    }

    public String getImage_path() {
        return image_path;
    }
}
