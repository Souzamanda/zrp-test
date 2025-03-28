package com.zrp_test.pokemon_api.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zrp_test.pokemon_api.entities.Sprites;

import java.util.List;

public class PokemonResponse {
    private String name;

    private String id;

    @JsonProperty("abilities")
    List<AbilityContainer> abilities;

    @JsonProperty("types")
    List<TypeContainer> types;

    @JsonProperty("sprites")
    Sprites sprites;

    public Sprites getSprites() {
        return sprites;
    }

    public List<TypeContainer> getTypes() {
        return types;
    }

    public String getName() {
        return name;
    }

    public List<AbilityContainer> getAbilities() {
        return abilities;
    }

    public String getId() {
        return id;
    }

    public PokemonResponse(String name) {
        this.name = name;
    }

    public PokemonResponse(String name, String id, List<AbilityContainer> abilities, List<TypeContainer> types, Sprites sprites) {
        this.name = name;
        this.id = id;
        this.abilities = abilities;
        this.types = types;
        this.sprites = sprites;
    }

    public PokemonResponse() {
    }
}
