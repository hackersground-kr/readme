package com.hackathon.readmeandroid.view.activity.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.databinding.ActivityAccountBinding
import com.hackathon.readmeandroid.view.fragment.account.LoginFragment
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class AccountActivity : AppCompatActivity() {

    companion object {
        lateinit var instance: AccountActivity
        fun ApplicationContext(): Context {
            return instance.applicationContext
        }
    }

    init {
        AccountActivity.instance = this

    }


    private val binding: ActivityAccountBinding by lazy {
        ActivityAccountBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        AppCenter.start(
            application, "dac78000-80e9-4658-9707-1db983d47a8c",
            Analytics::class.java,
            Crashes::class.java
        )

        val loginFragment = LoginFragment()
        navigateToFragment(loginFragment)
    }

    fun nextActivivty(mainIntent: Intent){
        nextActivivty(mainIntent)
    }

    private fun navigateToFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.account_screen, fragment)
        transaction.commit()
    }
}