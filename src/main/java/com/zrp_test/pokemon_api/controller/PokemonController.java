package com.zrp_test.pokemon_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @GetMapping("/{name}")
    public Object getPokemon(@PathVariable String name) {
        RestTemplate restTemplate = new RestTemplate();
        Object object = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/{name}", Object.class, name);

        return object;
    }
}
