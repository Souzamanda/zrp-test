package com.zrp_test.pokemon_api.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class PokemonExceptionHandler {
    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity pokemonNotFound(HttpClientErrorException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokémon não encontrado!\nVerifique o nome e tente novamente.");
    }
}
