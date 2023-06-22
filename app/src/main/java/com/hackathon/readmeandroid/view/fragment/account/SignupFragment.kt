package com.hackathon.readmeandroid.view.fragment.account

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hackathon.readmeandroid.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentSignupBinding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

}