package es.iessaladillo.pedrojoya.intents

import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import kotlin.math.max

class Fight(
        private val opponentOne: Pokemon,
        private val opponentTwo: Pokemon,
) {

    /**
     * @return the pokemon with more strength
     */
    fun startFight(): Pokemon {
        val maxPower = max(opponentOne.power, opponentTwo.power)
        return if (opponentOne.power == maxPower) opponentOne else opponentTwo
    }

}