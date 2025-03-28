package com.zrp_test.pokemon_api.services;

import com.zrp_test.pokemon_api.clients.PokemonResponse;
import com.zrp_test.pokemon_api.dtos.PokemonDTO;
import com.zrp_test.pokemon_api.entities.Sprites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${application.pokeapi.url}")
    private String pokeapiUrl;

    public PokemonDTO getPokemon(String name) throws Exception {
        try {
            PokemonResponse pokemonResponse = restTemplate.getForObject(pokeapiUrl+"{name}", PokemonResponse.class, name);

            String pokemonName = pokemonResponse.getName();
            String pokemonId = pokemonResponse.getId();
            List<String> abilities = pokemonResponse.getAbilities().stream()
                    .map(abilityContainer -> abilityContainer.getAbility().getName())
                    .sorted().toList();
            List<String> types = pokemonResponse.getTypes().stream()
                    .map(typeContainer -> typeContainer.getType().getName()).toList();
            Sprites sprites = pokemonResponse.getSprites();

            return new PokemonDTO(pokemonName, pokemonId, abilities, types, sprites);
        } catch (RestClientResponseException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
            } else {
                throw new Exception("Erro ao buscar pokémon");
            }
        }
    }
}
