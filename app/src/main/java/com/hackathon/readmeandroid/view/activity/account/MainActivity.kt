package com.hackathon.readmeandroid.view.activity.account

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.controller.MainRecyclerView
import com.hackathon.readmeandroid.databinding.ActivityMainBinding
import com.hackathon.readmeandroid.model.ItemCardMain
import com.hackathon.readmeandroid.view.fragment.main.FavoritesFragment
import com.hackathon.readmeandroid.view.fragment.main.MainFragment
import com.hackathon.readmeandroid.view.fragment.main.MyPageFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val vp by lazy {
        binding.vp
    }

    private val bn by lazy {
        binding.bn
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        vp.apply {
            adapter = ViewPagerAdapter(this@MainActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    bn.selectedItemId = when (position) {
                        0 -> R.id.mypageFragment
                        1 -> R.id.homeFragment
                        else -> R.id.favoritesFragment
                    }
                }
            })
            // 초기 페이지를 2번째 화면으로 설정
            currentItem = 1
        }

        bn.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.mypageFragment -> vp.currentItem = 0
                R.id.homeFragment -> vp.currentItem = 1
                else -> vp.currentItem = 2
            }
            true
        }
    }

    inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> MyPageFragment()
                1 -> MainFragment()
                else -> FavoritesFragment()
            }
        }
    }

}