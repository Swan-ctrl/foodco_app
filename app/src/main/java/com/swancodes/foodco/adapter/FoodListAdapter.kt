package com.swancodes.foodco.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.foodco.R
import com.swancodes.foodco.model.Food

class FoodListAdapter(
    private val dataset: List<Food>,
    private val onFoodItemClicked: (Food) -> Unit,
) :
    RecyclerView.Adapter<FoodListAdapter.FoodListViewHolder>() {

    class FoodListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val foodImage: ImageView = view.findViewById(R.id.item_food_image)
        val foodTxt: TextView = view.findViewById(R.id.item_food_title)
        val priceTxt: TextView = view.findViewById(R.id.item_food_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)


        return FoodListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: FoodListViewHolder, position: Int) {
        val item = dataset[position]
        holder.foodImage.setImageResource(item.imageResourceId)
        holder.foodTxt.text = item.name
        holder.priceTxt.text = item.price


        holder.foodImage.setOnClickListener {
            onFoodItemClicked(item)
        }
    }

    override fun getItemCount() = dataset.size
}
