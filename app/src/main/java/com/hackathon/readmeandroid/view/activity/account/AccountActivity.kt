package com.hackathon.readmeandroid.view.activity.account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackathon.readmeandroid.databinding.ActivityAccountBinding
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class AccountActivity : AppCompatActivity() {
    private val binding: ActivityAccountBinding by lazy { ActivityAccountBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        AppCenter.start(
            application, "dac78000-80e9-4658-9707-1db983d47a8c",
            Analytics::class.java,
            Crashes::class.java
        )
    }
}