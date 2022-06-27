package com.diegoalvis.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

internal class SharedPreferencesCache(
    context: Context,
    preferencesName: String
) : Cache {

    private val preferences: SharedPreferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    override fun saveBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    override fun readBoolean(key: String, defValue: Boolean): Boolean {
        return preferences.getBoolean(key, defValue)
    }

    override fun saveString(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    override fun readString(key: String): String? {
        return preferences.getString(key, null)
    }

    override fun removeValue(key: String) {
        editor.remove(key)
        editor.apply()
    }

    override fun saveObject(key: String, obj: Any) {
        val json = Gson().toJson(obj)
        editor.putString(key, json)
        editor.commit()
    }

    override fun readObject(key: String): Any? {
        val json = preferences.getString(key, null)
        return json?.jsonToObjectOrNull()
    }

    override fun clearAll() {
        editor.clear()
        editor.apply()
    }
}


inline fun <reified T> String.jsonToObjectOrNull(): T? = try {
    Gson().fromJson(this, T::class.java)
} catch (e: Exception) {
    null
}