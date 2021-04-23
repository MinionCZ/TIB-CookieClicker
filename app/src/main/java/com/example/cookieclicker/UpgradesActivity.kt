package com.example.cookieclicker

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UpgradesActivity : AppCompatActivity(){
    lateinit var cookieData : CookieData
    lateinit var autoClickerTextView: TextView
    lateinit var workersTextView: TextView
    lateinit var bakeriesTextView: TextView
    lateinit var upgradeClickTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upgrade_activity)
        cookieData = intent.getSerializableExtra("cookieData") as CookieData
        Log.i("App", cookieData.toString())
        autoClickerTextView = findViewById(R.id.autoClickerText)
        workersTextView = findViewById(R.id.workersText)
        bakeriesTextView = findViewById(R.id.bakeriesText)
        upgradeClickTextView = findViewById(R.id.clickUpgradeText)
        refreshTextViews()
    }
    fun refreshTextViews(){
        autoClickerTextView.text = "Autoclicker upgrade level: ${cookieData.autoClickerUpgradeLevel}\n" + "Upgrade cost: xxx"
        workersTextView.text = "Working works: ${cookieData.workersUpgradeLevel}\nWorker cost: xxx"
        bakeriesTextView.text = "Baking bakeries: ${cookieData.bakeriesUpgradeLevel}\nBakery cost: xxx"
        upgradeClickTextView.text = "Upgrade click level: ${cookieData.clickUpgradeLevel}\nUpgrade cost: xxx"
    }


}