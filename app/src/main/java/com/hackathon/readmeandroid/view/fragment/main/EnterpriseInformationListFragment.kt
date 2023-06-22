package com.hackathon.readmeandroid.view.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hackathon.readmeandroid.databinding.FragmentEnterpriseInformationListBinding

class EnterpriseInformationListFragment : Fragment() {

    private lateinit var binding: FragmentEnterpriseInformationListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterpriseInformationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 받아온 타이틀을 표시
        val title = arguments?.getString(ARG_TITLE)
        binding.textViewTitle.text = title
    }

    companion object {
        private const val ARG_TITLE = "title"

        fun newInstance(title: String): EnterpriseInformationListFragment {
            val fragment = EnterpriseInformationListFragment()
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            fragment.arguments = args
            return fragment
        }
    }
}
