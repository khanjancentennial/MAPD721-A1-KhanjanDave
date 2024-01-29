package com.example.mapd721_a1_khanjandave

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreData(private val context: Context) {

    // Companion object to create a single instance of DataStore for username, email and id
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserData")

        // Keys to uniquely identify username, email and id in DataStore
        val USER_NAME_KEY = stringPreferencesKey("user_name")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
        val USER_ID_KEY = stringPreferencesKey("user_id")
    }
    // Flow representing the user's stored username
    val getUsername: Flow<String?> = context.dataStore.data
        .map { preferences ->
            // Retrieve the stored username value or return an empty string if not present
            preferences[USER_NAME_KEY] ?: ""
        }

    // Flow representing the user's stored email
    val getEmail: Flow<String?> = context.dataStore.data
        .map { preferences ->
            // Retrieve the stored email value or return an empty string if not present
            preferences[USER_EMAIL_KEY] ?: ""
        }

    // Flow representing the user's stored id
    val getId: Flow<String?> = context.dataStore.data
        .map { preferences ->
            // Retrieve the stored id value or return an empty string if not present
            preferences[USER_ID_KEY] ?: ""
        }

    // Function to save username, email and id in DataStore
    suspend fun saveData(username: String, email: String, id: String) {
        // Use the DataStore's edit function to make changes to the stored preferences
        context.dataStore.edit { preferences ->
            // Update the user email and password values in the preferences
            preferences[USER_NAME_KEY] = username
            preferences[USER_EMAIL_KEY] = email
            preferences[USER_ID_KEY] = id
        }
    }




}