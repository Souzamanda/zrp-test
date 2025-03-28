package com.zrp_test.pokemon_api.service;

import com.zrp_test.pokemon_api.clients.AbilityContainer;
import com.zrp_test.pokemon_api.clients.PokemonResponse;
import com.zrp_test.pokemon_api.clients.TypeContainer;
import com.zrp_test.pokemon_api.components.RestTemplateComponent;
import com.zrp_test.pokemon_api.entities.Ability;
import com.zrp_test.pokemon_api.entities.Sprites;
import com.zrp_test.pokemon_api.entities.Type;
import com.zrp_test.pokemon_api.services.PokemonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PokemonServiceTest {
    @InjectMocks
    private PokemonService pokemonService;

    @Mock
    private RestTemplate restTemplate;

    private String apiUrl = "https://pokeapi.co/api/v2/pokemon/";

    @BeforeEach
    void setup() {
        ReflectionTestUtils.setField(pokemonService, "pokeapiUrl", apiUrl);
    }

    @Test
    void getPokemonFound() throws Exception {
        List<AbilityContainer> abilities = List.of(new AbilityContainer(new Ability("imposter")), new AbilityContainer(new Ability("limber")));
        List<TypeContainer> types = List.of(new TypeContainer(new Type("normal")));
        Sprites sprites = new Sprites("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/132.png");
        PokemonResponse ditto = new PokemonResponse("ditto", abilities, types, sprites);
        Mockito.when(restTemplate.getForObject(apiUrl+"{name}", PokemonResponse.class, "ditto")).thenReturn(ditto);
        var response = pokemonService.getPokemon("ditto");

        Assertions.assertNotNull(response);
    }

    @Test
    void getPokemonNotFound() {
        RestClientResponseException exception = new RestClientResponseException("Pokémon não encontrado", HttpStatus.NOT_FOUND, "Not found", HttpHeaders.EMPTY, new byte[0], Charset.defaultCharset());
        Mockito.when(restTemplate.getForObject(apiUrl+"{name}", PokemonResponse.class, "ditt")).thenThrow(exception);

        Assertions.assertThrows(RestClientResponseException.class, () -> pokemonService.getPokemon("ditt"));
    }
}
