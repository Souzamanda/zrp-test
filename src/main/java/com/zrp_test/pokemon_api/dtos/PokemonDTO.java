package com.zrp_test.pokemon_api.dtos;

import java.util.List;

public record PokemonDTO(String name, List<String> abilities) {
}
