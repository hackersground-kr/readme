package com.hackathon.readmeandroid.view.fragment.account

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.databinding.FragmentSignupBinding
import com.hackathon.readmeandroid.model.network.Client
import com.hackathon.readmeandroid.model.network.dto.request.SignupStudentRequest
import com.hackathon.readmeandroid.model.network.dto.response.signupstudentresponse.SignupStudentResponse
import com.hackathon.readmeandroid.view.activity.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class SignupFragment : Fragment() {

    private var year = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSignupBinding =
            FragmentSignupBinding.inflate(inflater, container, false)


        binding.SignupButton.setOnClickListener {
            val email = binding.textMail.text.toString()
            val grade = calculateAge(binding.birthday.toString())
            val location = binding.location.text.toString()
            val name = binding.textName.text.toString()
            val password = binding.textPassword.text.toString()
            val birthday = binding.birthday.text.toString()
            val passwordCheck = binding.textCheckPassword.text.toString()

            signup(birthday, email, grade, location, name, password, passwordCheck)
        }


        return binding.root
    }

    private fun calculateAge(birthDate: String): Int {
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault())
        val currentDate = Calendar.getInstance()

        val dateOfBirth = dateFormat.parse(birthDate)
        val birthCalendar = Calendar.getInstance()
        if (dateOfBirth != null) {
            birthCalendar.time = dateOfBirth
        }

        var age = currentDate.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR)

        // 현재 월일이 생년월일보다 이전인 경우에는 나이에서 1을 뺍니다.
        if (currentDate < birthCalendar) {
            age--
        }

        return age
    }


    private fun signup(
        birth: String,
        email: String,
        grade: Int,
        location: String,
        name: String,
        password: String,
        passwordCheck: String
    ) {
        Client.api.signup(
            SignupStudentRequest(
                birth = birth,
                email = email,
                grade = grade,
                location = location,
                name = name,
                password = password
            )
        ).enqueue(object : Callback<SignupStudentResponse> {
            override fun onResponse(
                call: Call<SignupStudentResponse>,
                response: Response<SignupStudentResponse>
            ) {
                if(passwordCheck == password){
                    if (response.isSuccessful) {
                        navigateToMainActivity()
                    } else {
                        Log.d("인터넷", response.code().toString())
                    }
                }
            }

            override fun onFailure(call: Call<SignupStudentResponse>, t: Throwable) {
                Log.d("ERROR", t.message.toString())
            }

        })
    }

    private fun navigateToMainActivity() {
        val intent = Intent(context, MainActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }


}