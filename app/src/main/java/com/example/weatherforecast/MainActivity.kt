package com.example.weatherforecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherforecast.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.helloHolder, MainFragment.newInstance()).commit()
    }
}