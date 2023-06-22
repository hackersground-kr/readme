package com.hackathon.readmeandroid.view.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.controller.MainRecyclerView
import com.hackathon.readmeandroid.databinding.FragmentMainBinding
import com.hackathon.readmeandroid.model.ItemCardMain

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        val recyclerView by lazy {
            binding.majorListScroll
        }

        val titles = listOf(
            "IT/정보통신", "건설", "교육", "금융/은행", "문화/예술/디자인",
            "미디어/광고", "서비스", "의료/제약", "제조/생산/화학", "판매/유통"
        )
        val items: ArrayList<ItemCardMain> = ArrayList()

        for (i in 0 until 10) {
            val title = titles[i] // 각 카드마다 다른 title 값 할당
            val imageResId = when (i % 10) {
                0 -> R.drawable.develop_image
                1 -> R.drawable.develop_image
                2 -> R.drawable.struct_image
                3 -> R.drawable.struct_image
                4 -> R.drawable.struct_image
                5 -> R.drawable.struct_image
                6 -> R.drawable.struct_image
                7 -> R.drawable.struct_image
                8 -> R.drawable.struct_image
                9 -> R.drawable.struct_image
                else -> R.drawable.develop_image
            }
            items.add(ItemCardMain(imageResId, title))
        }

        val adapter = MainRecyclerView(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }
}
