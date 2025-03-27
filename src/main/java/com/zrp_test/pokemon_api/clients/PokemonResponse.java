package com.zrp_test.pokemon_api.clients;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonResponse {
    private String name;

    @JsonProperty("abilities")
    List<AbilityContainer> abilities;

    @JsonProperty("types")
    List<TypeContainer> types;

    public List<TypeContainer> getTypes() {
        return types;
    }

    public String getName() {
        return name;
    }

    public List<AbilityContainer> getAbilities() {
        return abilities;
    }
}
