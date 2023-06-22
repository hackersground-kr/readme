package com.hackathon.readmeandroid.view.activity.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.readmeandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var instance: MainActivity
        fun ApplicationContext() : Context {
            return instance.applicationContext
        }
    }

    init{
        MainActivity.instance = this
    }

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }

    fun nextActivity(accountIntent: Intent) {
        val accountIntent: Intent = Intent(this, AccountActivity::class.java)
        nextActivity(accountIntent)
        finish()
    }
}