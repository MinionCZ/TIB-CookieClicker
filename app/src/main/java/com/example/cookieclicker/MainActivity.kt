package com.example.cookieclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val cookieData = CookieData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupClickButton()
        setupUpgradeButton()
    }
    fun setupClickButton(){
        val button = findViewById<ImageButton>(R.id.imageButton)
        button.setOnClickListener {
            cookieData.cookiesCounter += cookieData.clickValue
            val cookiesTextView = findViewById<TextView>(R.id.cookieTextArea)
            cookiesTextView.text = "Cookies count: ${cookieData.cookiesCounter}"
        }
    }
    fun setupUpgradeButton(){
        val button = findViewById<Button>(R.id.upgradeButton)
        button.setOnClickListener {
            val intent = Intent(this, UpgradesActivity::class.java)
            intent.putExtra("cookieData", cookieData)
            startActivity(intent)
        }
    }
}