package com.zrp_test.pokemon_api.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zrp_test.pokemon_api.entities.Ability;

public class AbilityContainer {
    @JsonProperty("ability")
    private Ability ability;

    public Ability getAbility() {
        return ability;
    }

    public AbilityContainer() {
    }

    public AbilityContainer(Ability ability) {
        this.ability = ability;
    }
}
