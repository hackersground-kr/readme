package com.hackathon.readmeandroid.view.fragment.account

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.databinding.FragmentLoginBinding
import com.hackathon.readmeandroid.model.network.Client
import com.hackathon.readmeandroid.model.network.dto.request.LoginReqeust
import com.hackathon.readmeandroid.model.network.dto.response.loginresponse.LoginResponse
import com.hackathon.readmeandroid.view.activity.account.AccountActivity
import com.hackathon.readmeandroid.view.activity.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private val accountActivity = AccountActivity()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        val signupFragment = SignupFragment()



        binding.loginButton.setOnClickListener {
            val password: String = binding.passwordText.text.toString()
            val email: String = binding.mailText.text.toString()

            Log.d("email", email)
            Log.d("password", password)
            login(email, password)
        }

        binding.signupText.setOnClickListener {
            navigateToFragment(signupFragment)
        }
        return binding.root
    }

    private fun login(email: String, password: String) {
        Client.api.login(LoginReqeust(email, password)).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    navigateToMainActivity()
                } else {
                    Log.d("인터넷", response.code().toString())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("ERROR", t.message.toString())
            }

        })

    }

    private fun navigateToMainActivity() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }


    private fun navigateToFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.account_screen, fragment)
        transaction?.commit()
    }

}