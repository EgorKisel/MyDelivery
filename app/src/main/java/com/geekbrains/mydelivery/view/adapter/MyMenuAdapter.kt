package com.geekbrains.mydelivery.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.geekbrains.mydelivery.R
import com.geekbrains.mydelivery.model.MenuDTOItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_food_item.view.*

class MyMenuAdapter(private val context: Context, private val menuList: MutableList<MenuDTOItem>) :
    RecyclerView.Adapter<MyMenuAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.photo_pizza
        val txt_name: TextView = itemView.mainFragmentRecyclerItemTextView

        fun bind(listItem: MenuDTOItem) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.photo_pizza}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.setOnClickListener {
                Toast.makeText(
                    it.context,
                    "нажал на ${itemView.mainFragmentRecyclerItemTextView.text}",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_food_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = menuList[position]
        holder.bind(listItem)

        Picasso.get().load(menuList[position].img).into(holder.image)
        holder.txt_name.text = menuList[position].name
    }

}