package com.example.digitalbusinesscard.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.digitalbusinesscard.data.model.Card
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.cardDataStore by preferencesDataStore("card_prefs")

class CardDataStore(private val context: Context) {
    private val gson = Gson()
    private val CARDS_KEY = stringPreferencesKey("cards")

    // Helper: parse list from JSON
    private fun parseJson(json: String?): MutableList<Card> {
        return if (json != null) {
            val type = object : TypeToken<MutableList<Card>>() {}.type
            gson.fromJson(json, type)
        } else mutableListOf()
    }

    // Add new card
    suspend fun saveCard(card: Card) {
        context.cardDataStore.edit { prefs ->
            val list = parseJson(prefs[CARDS_KEY])
            list.add(card)
            prefs[CARDS_KEY] = gson.toJson(list)
        }
    }

    // Update existing card
    suspend fun updateCard(updated: Card) {
        context.cardDataStore.edit { prefs ->
            val list = parseJson(prefs[CARDS_KEY])
            val index = list.indexOfFirst { it.id == updated.id }
            if (index != -1) {
                list[index] = updated
                prefs[CARDS_KEY] = gson.toJson(list)
            }
        }
    }

    // Delete card
    suspend fun deleteCard(id: String) {
        context.cardDataStore.edit { prefs ->
            val list = parseJson(prefs[CARDS_KEY])
            list.removeAll { it.id == id }
            prefs[CARDS_KEY] = gson.toJson(list)
        }
    }

    // Get all cards
    fun getCards(): Flow<List<Card>> {
        return context.cardDataStore.data.map { prefs ->
            val json = prefs[CARDS_KEY]
            parseJson(json)
        }
    }
}