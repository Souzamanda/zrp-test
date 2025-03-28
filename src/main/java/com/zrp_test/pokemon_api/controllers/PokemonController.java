package com.zrp_test.pokemon_api.controllers;

import com.zrp_test.pokemon_api.dtos.PokemonDTO;
import com.zrp_test.pokemon_api.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/{name}")
    public PokemonDTO getPokemon(@PathVariable String name) throws Exception {
        return pokemonService.getPokemon(name);
    }
}
