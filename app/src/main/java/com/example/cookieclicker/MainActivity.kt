package com.example.cookieclicker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var cookieData = CookieData()
    val upgradeRequestCode = 10
    val handler = Handler()
    lateinit var timer: Runnable
    val secondInMillis = 1000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupClickButton()
        setupUpgradeButton()
        initTimer()
    }

    fun setupClickButton() {
        val button = findViewById<ImageButton>(R.id.imageButton)
        button.setOnClickListener {
            cookieData.cookiesCounter += cookieData.clickValue
            refreshCookieView()
        }
    }

    fun setupUpgradeButton() {
        val button = findViewById<Button>(R.id.upgradeButton)
        button.setOnClickListener {
            val intent = Intent(this, UpgradesActivity::class.java)
            intent.putExtra("cookieData", cookieData)
            startActivityForResult(intent, upgradeRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == upgradeRequestCode && resultCode == Activity.RESULT_OK) {
            cookieData = data!!.getSerializableExtra("cookieData") as CookieData
            refreshCookieView()
        }
    }

    fun initTimer() {
        timer = Runnable {
                cookieData.cookiesCounter += cookieData.cookiesPerSecond
                refreshCookieView()
                handler.postDelayed(timer, 1000)
        }
        handler.postDelayed(timer, 1000)
    }

    fun refreshCookieView() {
        val cookiesTextView: TextView = findViewById(R.id.cookieTextArea)
        cookiesTextView.text = "Cookies count: ${cookieData.cookiesCounter}"
        Log.i("App", "tick")

    }
}