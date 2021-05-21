package com.example.cookieclicker

import java.io.Serializable
import kotlin.math.pow
import kotlin.math.round


class CookieData : Serializable{
    var cookiesCounter : Long = 0
    var clickValue : Long = 1
    var cookiesPerSecond : Long = 0
    var clickUpgradeLevel : Long = 1
    var autoClickerUpgradeLevel : Long = 0
    var workersUpgradeLevel : Long = 0
    var bakeriesUpgradeLevel : Long = 0
    val clickUpgradeStartPrice : Long = 20
    val priceIncreaseCoef : Double = 2.5
    val increaseUpgradeValue : Double = 2.0

    override fun toString():String{
        var buffer = "{ cookiesCounter: $cookiesCounter, "
        buffer += "clickValue: $clickValue, "
        buffer += "cookiesPerSecond $cookiesPerSecond, "
        buffer += "clickUpgradeLevel: $clickUpgradeLevel, "
        buffer += "autoClickerUpgradeLevel: $autoClickerUpgradeLevel }"
        return buffer
    }

    fun getClickUpgPrice() : Long{
        var upgradeValue = clickUpgradeStartPrice * priceIncreaseCoef.pow((clickUpgradeLevel - 1).toDouble())
        return  upgradeValue.toLong()
    }

    fun calculateClickValue(){
        clickValue *= 2
    }


}