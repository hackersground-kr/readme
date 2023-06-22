import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

        binding.majorListScroll.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_favoritesFragment)
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
            items.add(ItemCardMain(imageResId, title))
        }

        val adapter = MainRecyclerView(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)


        return binding.root
    }
}
