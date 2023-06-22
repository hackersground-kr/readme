package com.hackathon.readmeandroid.view.fragment.account

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.databinding.FragmentLoginBinding
import com.hackathon.readmeandroid.databinding.FragmentSignupBinding
import com.hackathon.readmeandroid.model.network.Client
import com.hackathon.readmeandroid.model.network.dto.request.LoginReqeust
import com.hackathon.readmeandroid.model.network.dto.request.SignupRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSignupBinding = FragmentSignupBinding.inflate(inflater, container, false)
        binding.SignupButton.setOnClickListener {
            val email = binding.textMail.text.toString()
            val password = binding.textPassword.text.toString()
            val name = binding.textSchoolName.text.toString()
            val school = binding.textSchoolName.text.toString()
        }
        return binding.root
    }



    private fun signup(email: String, password: String, name: String, schoolName: String) {
        Client.api.signup(SignupRequest(email,name,password,schoolName)).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("회원가입에 실패하셨습니다.",response.code().toString())
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.d("ERROR",t.message.toString())
            }

        })

    }


}