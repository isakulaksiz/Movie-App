package com.isilon.movieapp

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.TextView
import com.isilon.movieapp.ui.main.view.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    lateinit var companyName: TextView
    lateinit var devName: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        companyName = findViewById(R.id.tv_company_name)
        devName = findViewById(R.id.tv_developer_name)

        val typeFace: Typeface = Typeface.createFromAsset(assets, "Allison Dream Demo.ttf")

        companyName.typeface = typeFace
        devName.typeface = typeFace

        // removed header bar (battery etc)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },2500)
    }
}