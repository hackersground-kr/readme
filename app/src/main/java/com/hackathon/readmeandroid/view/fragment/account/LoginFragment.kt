package com.hackathon.readmeandroid.view.fragment.account

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
import com.hackathon.readmeandroid.view.activity.account.AccountActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginFragment : Fragment() {

    private val accountActivity = AccountActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentLoginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        val signupFragment = SignupFragment()

        binding.loginButton.setOnClickListener {
            val password = binding.passwordText.text.toString()
            val email = binding.mailText.text.toString()
            login(email ?: "", password ?: "")
        }

        binding.signupText.setOnClickListener {
            navigateToFragment(signupFragment)
        }
        return binding.root
    }

    private fun login(email: String, password: String) {
        Client.api.login(LoginReqeust(email, password)).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful) {
                    Log.d("인터넷", response.code().toString())
                } else {
                    Log.d("인터넷", response.code().toString())
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.d("ERROR", t.message.toString())
            }

        })

    }


    private fun navigateToFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.account_screen, fragment)
        transaction?.commit()
    }

}