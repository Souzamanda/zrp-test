package com.zrp_test.pokemon_api.entities;

public class Sprites {
    private String front_default;

    private String front_shiny;

    public String getFront_default() {
        return front_default;
    }

    public String getFront_shiny() {
        return front_shiny;
    }

    public Sprites() {
    }

    public Sprites(String front_default, String front_shiny) {
        this.front_default = front_default;
        this.front_shiny = front_shiny;
    }
}
