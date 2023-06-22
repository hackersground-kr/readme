package com.hackathon.readmeandroid.controller

import MainFragment
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hackathon.readmeandroid.R
import com.hackathon.readmeandroid.model.ItemCardFavorites

class FavoritesRecyclerView (items: ArrayList<ItemCardFavorites>) : RecyclerView.Adapter<FavoritesRecyclerView.MyViewHolder>() {

    var items = items

    private val mainFragment = MainFragment()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var Image: ImageView = itemView.findViewById(R.id.favorite_card_image)
        var Name: TextView = itemView.findViewById(R.id.enterprise_name)
        var locate: TextView = itemView.findViewById(R.id.enterprise_locate)

        fun bind(position: Int) {
//            tvImage.setImageResource(items[position].image)
            Image.setBackgroundResource(items[position].image)
            Name.text = items[position].enterprisename
            locate.text = items[position].enterpriselocation

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.favorites_cardview_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
        holder.Image.setOnClickListener{

        }
    }

    override fun getItemCount(): Int = items.size

    fun addPerson(item: ItemCardFavorites) {
        items.add(item)
    }


}