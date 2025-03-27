package com.zrp_test.pokemon_api.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zrp_test.pokemon_api.entities.Type;

public class TypeContainer {

    @JsonProperty("type")
    private Type type;

    public Type getType() {
        return type;
    }
}
