package com.solipsar.tasktape.multilanguagesupportingapp

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var myLocale: Locale? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_hindi.setOnClickListener {
            setLocale("hi")
        }

        btn_english.setOnClickListener {
            setLocale("en")
        }

    }

    private fun setLocale(localeName: String) {
            myLocale = Locale(localeName)
            val res: Resources = resources
            val dm: DisplayMetrics = res.displayMetrics
            val conf: Configuration = res.configuration
            conf.setLocale(myLocale)
            res.updateConfiguration(conf, dm)
            val refresh = Intent(this, MainActivity::class.java)
            startActivity(refresh)
    }
}