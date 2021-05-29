package space.ganeshhulyal.multilanguageapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPrefsManager: SharedPrefsManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPrefsManager = SharedPrefsManager(this)
        findViewById<MaterialButton>(R.id.change_language).setOnClickListener {
            sharedPrefsManager.saveStringValue("selected_language"," ")
            startActivity(Intent(Activity@this,SelectLanguageActivity::class.java))
        }
    }
}