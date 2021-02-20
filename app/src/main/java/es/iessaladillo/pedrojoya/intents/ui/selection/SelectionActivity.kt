package es.iessaladillo.pedrojoya.intents.ui.selection

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.data.local.DataSource
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.databinding.SelectionActivityBinding
import es.iessaladillo.pedrojoya.intents.utils.DEFAULT_LONG_EXTRA_VALUE
import es.iessaladillo.pedrojoya.intents.utils.EXTRA_POKEMON_ID
import es.iessaladillo.pedrojoya.intents.utils.requireLongExtra


class SelectionActivity : AppCompatActivity() {

    private val binding: SelectionActivityBinding by lazy {
        SelectionActivityBinding.inflate(layoutInflater)
    }
    private var currentPokemonId: Long = 1

    private val pokemonDB: DataSource = Database

    private val pokemons: Map<Long, List<View?>> by lazy {
        mapOf(
                Pair(1, listOf(binding.selectionImg1, binding.selectionRdbName1)),
                Pair(2, listOf(binding.selectionImg2, binding.selectionRdbName2)),
                Pair(3, listOf(binding.selectionImg3, binding.selectionRdbName3)),
                Pair(4, listOf(binding.selectionImg4, binding.selectionRdbName4)),
                Pair(5, listOf(binding.selectionImg5, binding.selectionRdbName5)),
                Pair(6, listOf(binding.selectionImg6, binding.selectionRdbName6)),
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
        setupViews()
    }

    private fun getIntentData() {
        currentPokemonId = intent.requireLongExtra(EXTRA_POKEMON_ID, DEFAULT_LONG_EXTRA_VALUE)
    }

    private fun setupViews() {
        (pokemons.getValue(currentPokemonId).last() as RadioButton).isChecked = true
        setData()
    }

    private fun setData() {
        for (pokemon in pokemonDB.getAllPokemons()) {
            pokemons.getValue(pokemon.id).run {
                val imgView = (first() as ImageView)
                imgView.setImageResource(pokemon.imageResId)
                imgView.setOnClickListener { selectPokemon(pokemon.id) }

                val rdb = (last() as RadioButton)
                rdb.text = pokemon.name
                rdb.setOnClickListener { selectPokemon(pokemon.id) }
            }
        }
    }


    private fun selectPokemon(pokemonSelected: Long) {
        (pokemons.getValue(currentPokemonId).last() as RadioButton).isChecked = false
        currentPokemonId = pokemonSelected
        (pokemons.getValue(currentPokemonId).last() as RadioButton).isChecked = true
    }

    override fun onBackPressed() {
        setActivityResult(currentPokemonId)
        super.onBackPressed()
    }

    private fun setActivityResult(pokemonId: Long) {
        val intent = Intent().putExtra(EXTRA_POKEMON_ID, pokemonId)
        setResult(RESULT_OK, intent)
    }


    companion object {

        fun newIntent(context: Context, pokemonId: Long): Intent =
                Intent(context, SelectionActivity::class.java)
                        .putExtra(EXTRA_POKEMON_ID, pokemonId)
    }
}