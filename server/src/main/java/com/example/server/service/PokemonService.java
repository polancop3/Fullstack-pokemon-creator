package com.example.server.service;

import com.example.server.model.Pokemons;
import org.springframework.http.HttpStatus;

public interface PokemonService {
    Iterable<Pokemons> getPokemons();
    Pokemons createPokemons (Pokemons pokemons);
    Pokemons updatePokemons (Pokemons pokemons);
    HttpStatus deletePokemons(Long id);
}
