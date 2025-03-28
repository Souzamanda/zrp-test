package com.zrp_test.pokemon_api.dtos;

import com.zrp_test.pokemon_api.entities.Sprites;
import java.util.List;

public record PokemonDTO(String name, List<String> abilities, List<String> types, Sprites sprites) {
}
