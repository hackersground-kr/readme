package com.hackathon.readmeandroid.controller

import MainFragment
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.model.ItemCardMain
import com.hackathon.readmeandroid.view.fragment.main.EnterpriseInformationListFragment

class MainRecyclerView(items: ArrayList<ItemCardMain>) : RecyclerView.Adapter<MainRecyclerView.MyViewHolder>(){

    var items = items
    private val mainFragment = MainFragment()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var tvImage: LinearLayout = itemView.findViewById(R.id.main_card_image)
        var tvName: TextView = itemView.findViewById(R.id.major)

        fun bind(position: Int) {
//            tvImage.setImageResource(items[position].image)
            tvImage.setBackgroundResource(items[position].image)
            tvName.text = items[position].major

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.main_cardview_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
        holder.tvImage.setOnClickListener{
            Log.d("클릭","이동")
            mainFragment.onclick(position)
        }
    }

    override fun getItemCount(): Int = items.size


}