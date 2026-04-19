package com.example.weatheringwithyou

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class WeatheringWithYouApplication : Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")//这个注释用来提示系统忽略内存泄漏，实际也没有内存泄漏
        lateinit var context: Context
        const val TOKEN = "5kc8Flu8UCjxfsQ2"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}