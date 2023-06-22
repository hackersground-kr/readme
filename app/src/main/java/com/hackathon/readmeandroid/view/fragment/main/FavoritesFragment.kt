package com.hackathon.readmeandroid.view.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.controller.FavoritesRecyclerView
import com.hackathon.readmeandroid.controller.OnClick
import com.hackathon.readmeandroid.databinding.FragmentFavoritesBinding
import com.hackathon.readmeandroid.model.ItemCardFavorites

class FavoritesFragment : Fragment(), OnClick {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        val recyclerView by lazy {
            binding.enterpriseListScroll
        }


        val titles = listOf(
            "회사줘사", "샘숭", "엘히", "블라", "문화/예술/디자인",
            "미디어/광고", "서비스", "의료/제약", "제조/생산/화학", "판매/유통"
        )

        val items: ArrayList<ItemCardFavorites> = ArrayList()

        val locates = listOf(
            "수성구 범어동", "건설", "교육", "금융/은행", "문화/예술/디자인",
            "미디어/광고", "서비스", "의료/제약", "제조/생산/화학", "판매/유통"
        )

        for (i in 0 until 10) {
            val title = titles[i] // 각 카드마다 다른 title 값 할당
            val locate = locates[i]
            val imageResId = when (i % 10) {
                0 -> R.drawable.develop_image
                1 -> R.drawable.struct_image
                2 -> R.drawable.edu_img
                3 -> R.drawable.capital_img
                4 -> R.drawable.art_img
                5 -> R.drawable.advertisement_img
                6 -> R.drawable.service_img
                7 -> R.drawable.medical_img
                8 -> R.drawable.manufacturing_img
                else -> R.drawable.circulation_img
            }
            items.add(ItemCardFavorites(imageResId, title, locate))
        }

        val adapter = FavoritesRecyclerView(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)


        return binding.root
    }

    override fun favoritesOnclickPhoto(position: Int) {

    }

    override fun mainOnclickPhoto(position: Int) {
        //사용 안함
    }

}