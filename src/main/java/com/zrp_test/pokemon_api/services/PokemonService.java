package com.zrp_test.pokemon_api.services;

import com.zrp_test.pokemon_api.clients.PokemonResponse;
import com.zrp_test.pokemon_api.dtos.PokemonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonService {
    private final RestTemplate restTemplate = new RestTemplate();

    public PokemonDTO getPokemon(String name) {
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
