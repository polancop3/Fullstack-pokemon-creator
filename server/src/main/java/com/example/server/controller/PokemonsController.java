package com.example.server.controller;

import com.example.server.model.Pokemons;
import com.example.server.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/pokemon")

public class PokemonsController {
    @Autowired
    PokemonService pokemonService;
    @GetMapping
    Iterable<Pokemons> getPokemons(){return pokemonService.getPokemons();}

    @PostMapping
    public Pokemons createPokemons(@RequestBody Pokemons pokemon){
        return pokemonService.createPokemons(pokemon);
    }
    @PatchMapping
    public Pokemons updatePokemons(@RequestBody Pokemons pokemon) {
        return pokemonService.updatePokemons(pokemon);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deletePokemon (@PathVariable Long id){
        return pokemonService.deletePokemons(id);
    }

}
