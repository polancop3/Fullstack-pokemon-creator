package com.example.server.repository;

import com.example.server.model.Pokemons;
import org.springframework.data.repository.CrudRepository;

public interface PokemonRepository extends CrudRepository<Pokemons,Long> {
}
