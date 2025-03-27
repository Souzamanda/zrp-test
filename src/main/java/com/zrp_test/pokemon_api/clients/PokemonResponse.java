package com.zrp_test.pokemon_api.clients;

import java.util.List;

public class PokemonResponse {
    private String name;
    List<AbilityContainer> abilities;

    public String getName() {
        return name;
    }

    public List<AbilityContainer> getAbilities() {
        return abilities;
    }
}
