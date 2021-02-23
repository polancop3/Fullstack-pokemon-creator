package com.example.server.service;

import com.example.server.model.Pokemons;
import com.example.server.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService{
    @Autowired
    PokemonRepository pokemonRepository;
    @Override
    public Iterable<Pokemons> getPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemons createPokemons(Pokemons pokemons) {
        return pokemonRepository.save(pokemons);
    }

    @Override
    public Pokemons updatePokemons(Pokemons pokemons) {
        return pokemonRepository.save(pokemons);
    }

    @Override
    public HttpStatus deletePokemons(Long id) {
         pokemonRepository.deleteById(id);
         return HttpStatus.OK;
    }
}
