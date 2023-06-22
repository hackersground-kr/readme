package com.hackathon.readmeandroid.view.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.databinding.ActivityMain2Binding
import com.hackathon.readmeandroid.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    private val binding: ActivityMain2Binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}