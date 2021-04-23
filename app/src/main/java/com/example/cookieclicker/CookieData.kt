package com.example.cookieclicker

import java.io.Serializable


class CookieData : Serializable{
    var cookiesCounter : Long = 0
    var clickValue : Long = 1
    var cookiesPerSecond : Long = 0
    var clickUpgradeLevel : Long = 1
    var autoClickerUpgradeLevel : Long = 0
    var workersUpgradeLevel : Long = 0
    var bakeriesUpgradeLevel : Long = 0



    override fun toString():String{
        var buffer = "{ cookiesCounter: $cookiesCounter, "
        buffer += "clickValue: $clickValue, "
        buffer += "cookiesPerSecond $cookiesPerSecond, "
        buffer += "clickUpgradeLevel: $clickUpgradeLevel, "
        buffer += "autoClickerUpgradeLevel: $autoClickerUpgradeLevel }"
        return buffer
    }
}