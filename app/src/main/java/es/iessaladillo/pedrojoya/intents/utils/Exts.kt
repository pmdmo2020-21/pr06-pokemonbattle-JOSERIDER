package es.iessaladillo.pedrojoya.intents.utils

import android.content.Intent


fun Intent.requireLongExtra(extraId:String, defaultValue: Long):Long {
    if (!hasExtra(extraId))  throw RuntimeException("Intent is not valid, must have  EXTRA_POKEMON_ID")
    return getLongExtra(extraId,defaultValue)
}