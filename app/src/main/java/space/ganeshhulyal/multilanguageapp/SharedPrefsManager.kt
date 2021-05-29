package space.ganeshhulyal.multilanguageapp

import android.content.Context
import android.content.SharedPreferences

class SharedPrefsManager(private val context: Context) {
    private var SharedPref: SharedPreferences =
        context.getSharedPreferences(
            "LanguageDemo", Context.MODE_PRIVATE
        )
    var editor: SharedPreferences.Editor = SharedPref.edit()
    fun saveStringValue(key: String?, value: String): Boolean {
        editor.putString(key, value).apply()
        return true
    }

    fun getStringValue(key: String?, defaultValue: String): String? {
        return SharedPref.getString(key, defaultValue)
    }


}