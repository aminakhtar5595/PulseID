package com.example.digitalbusinesscard.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.digitalbusinesscard.data.model.Contact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.contactDataStore by preferencesDataStore("contact_prefs")

class ContactDataStore(private val context: Context) {
    private val gson = Gson()
    private val CONTACT_KEY = stringPreferencesKey("contact")

    // Helper: parse list from JSON
    private fun parseJson(json: String?): MutableList<Contact> {
        return if (json != null) {
            val type = object : TypeToken<MutableList<Contact>>() {}.type
            gson.fromJson(json, type)
        } else mutableListOf()
    }

    // Add new contact
    suspend fun saveContact(contact: Contact) {
        context.contactDataStore.edit { prefs ->
            val list = parseJson(prefs[CONTACT_KEY])
            list.add(contact)
            prefs[CONTACT_KEY] = gson.toJson(list)
        }
    }

    // Update existing contact
    suspend fun updateContact(updated: Contact) {
        context.contactDataStore.edit { prefs ->
            val list = parseJson(prefs[CONTACT_KEY])
            val index = list.indexOfFirst { it.id == updated.id }
            if (index != -1) {
                list[index] = updated
                prefs[CONTACT_KEY] = gson.toJson(list)
            }
        }
    }

    // Delete contact
    suspend fun deleteContact(id: String) {
        context.contactDataStore.edit { prefs ->
            val list = parseJson(prefs[CONTACT_KEY])
            list.removeAll { it.id == id }
            prefs[CONTACT_KEY] = gson.toJson(list)
        }
    }

    // Get all contact
    fun getContacts(): Flow<List<Contact>> {
        return context.contactDataStore.data.map { prefs ->
            val json = prefs[CONTACT_KEY]
            parseJson(json)
        }
    }
}