package space.ganeshhulyal.multilanguageapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import space.ganeshhulyal.multilanguageapp.databinding.ActivitySelectLanguageBinding
import java.util.*

class SelectLanguageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectLanguageBinding
    private lateinit var sharedPrefsManager: SharedPrefsManager
    val ENGLISH = "en"
    val HINDI = "hi"
    val KANNADA = "kn"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefsManager = SharedPrefsManager(this)
        if(sharedPrefsManager.getStringValue("selected_language"," ")==" "){
            selectLanguage()
        }else{
            goToMainActivity()
        }
    }

    private fun selectLanguage() {
        binding.btnEnglishLanguage.setOnClickListener {
            sharedPrefsManager.saveStringValue("selected_language",ENGLISH)
            setLocale(ENGLISH)
        }
        binding.btnHindiLanguage.setOnClickListener {
            sharedPrefsManager.saveStringValue("selected_language",HINDI)
            setLocale(HINDI)
        }
        binding.btnKannadaLanguage.setOnClickListener {
            sharedPrefsManager.saveStringValue("selected_language",KANNADA)
            setLocale(KANNADA)
        }
    }

    private fun setLocale(languageCode: String?) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources = this.resources
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
        goToMainActivity()
    }

    private fun goToMainActivity() {
        startActivity(Intent(Activity@this,MainActivity::class.java))
    }
}