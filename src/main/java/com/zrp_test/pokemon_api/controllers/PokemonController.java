package com.zrp_test.pokemon_api.controllers;

import com.zrp_test.pokemon_api.clients.PokemonResponse;
import com.zrp_test.pokemon_api.dtos.PokemonDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @GetMapping("/{name}")
    public PokemonDTO getPokemon(@PathVariable String name) {
        RestTemplate restTemplate = new RestTemplate();
        PokemonResponse pokemonResponse = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/{name}", PokemonResponse.class, name);

        String pokemonName = pokemonResponse.getName();
        List<String> abilities = pokemonResponse.getAbilities().stream()
                .map(abilityContainer -> abilityContainer.getAbility().getName())
                .sorted().toList();
        List<String> types = pokemonResponse.getTypes().stream()
                .map(typeContainer -> typeContainer.getType().getName()).toList();

        return new PokemonDTO(pokemonName, abilities, types);
    }
}
