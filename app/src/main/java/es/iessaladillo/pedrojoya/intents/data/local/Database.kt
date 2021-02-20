package es.iessaladillo.pedrojoya.intents.data.local

import es.iessaladillo.pedrojoya.intents.R
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon

object Database:DataSource {
   private val pokemonList:List<Pokemon> = listOf(
           Pokemon(1,"Pikachu", R.drawable.pikachu,100),
           Pokemon(2,"Gyarados",R.drawable.gyarados,150),
           Pokemon(3,"Cubone",R.drawable.cubone,45),
           Pokemon(4,"feebas",R.drawable.feebas,70),
           Pokemon(5,"Giratina",R.drawable.giratina,90),
           Pokemon(6,"Bulbasur",R.drawable.bulbasur,200),
   )


    override fun getRandomPokemon(): Pokemon = pokemonList.random()

    override fun getAllPokemons(): List<Pokemon> =
            pokemonList.toList()

    override fun getPokemonById(id: Long): Pokemon? =
            pokemonList.find { pokemon -> pokemon.id == id }

}