package es.iessaladillo.pedrojoya.intents.data.local

import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon

// IMPORTANTE: NO TOCAR
interface DataSource {
    fun getRandomPokemon(): Pokemon
    fun getAllPokemons(): List<Pokemon>
    fun getPokemonById(id: Long): Pokemon?
}