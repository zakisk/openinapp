package com.openinapp.domain.misc

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by: Mohammed Zaki
* */

class SharedPreferencesUtil(context: Context) {
    private val pref: SharedPreferences =
        context.getSharedPreferences("PREF_OPEN_IN_APP", Context.MODE_PRIVATE)

    @Suppress("UNCHECKED_CAST")
    fun <T : Any?> get(key: String): T? {
        return pref.all.getOrDefault(key, null) as T
    }

    fun <T> put(key: String, value: T) {
        pref.edit {
            when (value) {
                is String -> putString(key, value).apply()
                is Int -> putInt(key, value).apply()
                is Boolean -> putBoolean(key, value).apply()
            }
        }
    }
}