package es.iessaladillo.pedrojoya.intents.ui.winner

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.intents.data.local.DataSource
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.WinnerActivityBinding
import es.iessaladillo.pedrojoya.intents.utils.DEFAULT_LONG_EXTRA_VALUE
import es.iessaladillo.pedrojoya.intents.utils.EXTRA_POKEMON_ID
import es.iessaladillo.pedrojoya.intents.utils.requireLongExtra

class WinnerActivity : AppCompatActivity() {

    private val pokemonDB: DataSource = Database

    private val winnerOpponent: Pokemon by lazy {
        pokemonDB.getPokemonById(
                intent.requireLongExtra(EXTRA_POKEMON_ID, DEFAULT_LONG_EXTRA_VALUE))!!
    }
    private val binding: WinnerActivityBinding by lazy {
        WinnerActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        showWinner()
    }

    private fun showWinner() {
        with(binding) {
            winnerImgPokemon.setImageResource(winnerOpponent.imageResId)
            winnerLblPokemonName.text = winnerOpponent.name
        }
    }

    companion object {
        fun newIntent(context: Context, pokemonId: Long): Intent =
                Intent(context, WinnerActivity::class.java).putExtra(EXTRA_POKEMON_ID, pokemonId)
    }
}