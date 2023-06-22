package com.hackathon.readmeandroid.view.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.controller.MainRecyclerView
import com.hackathon.readmeandroid.databinding.FragmentMainBinding
import com.hackathon.readmeandroid.model.ItemCardMain

class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        //
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        val recylcerView by lazy {
            binding.majorListScroll
        }

        var items: ArrayList<ItemCardMain> = ArrayList()
        for (i in 0 until 10) {
            items.add(ItemCardMain(
                R.drawable.image002,
                "개발 $i")
            )
        }

        var adapter = MainRecyclerView(items)
        recylcerView.adapter = adapter
        recylcerView.layoutManager = GridLayoutManager(
            context, 2
        )

        // 프래그먼트 레이아웃 뷰 반환
        return binding.root
    }


}