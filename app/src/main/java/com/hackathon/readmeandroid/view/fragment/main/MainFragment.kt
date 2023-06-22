import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.controller.MainRecyclerView
import com.hackathon.readmeandroid.databinding.FragmentMainBinding
import com.hackathon.readmeandroid.model.ItemCardMain

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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

    fun onclick(position: Int) {
        val data = Bundle()
        when (position) {
            0 -> {
                data.putString("0","IT/정보통신")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            1 -> {
                data.putString("1","건설")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            2 -> {
                data.putString("2","교육")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            3 -> {
                data.putString("3","금융/은행")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            4 -> {
                data.putString("4","문화/예술/디자인")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            5 -> {
                data.putString("5","미디어/광고")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            6 -> {
                data.putString("6","서비스")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            7 -> {
                data.putString("7","의료/제약")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            8 -> {
                data.putString("8","제조/생산/화학")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            9 -> {
                data.putString("9","판매/유통")
                navigateToDestinationWithArgs(R.id.action_homefragment_to_enterprisefragment, data)
            }
            else -> {
                toast("ERROR")
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        // 현 Activity 에 연결된 Fragment 관리하는 supportFragmentManager 를 통해 Fragment 전환
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.account_screen, fragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
    }

    fun Fragment.navigateToDestinationWithArgs(destinationId: Int, args: Bundle) {
        val navController = findNavController()
        navController.navigate(destinationId, args)
    }
}
