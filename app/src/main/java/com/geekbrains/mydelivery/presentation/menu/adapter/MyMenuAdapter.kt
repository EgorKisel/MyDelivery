package com.geekbrains.mydelivery.presentation.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.geekbrains.mydelivery.R
import com.geekbrains.mydelivery.data.model.MenuDTOItem
import kotlinx.android.synthetic.main.recycler_food_item.view.*

class MyMenuAdapter(private var data: List<MenuDTOItem> = listOf()) :
    RecyclerView.Adapter<MyMenuAdapter.MyViewHolder>() {

    fun setData(dataNew: List<MenuDTOItem>) {
        this.data = dataNew
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.photo_pizza
        val txtName: TextView = itemView.mainFragmentRecyclerItemTextView

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

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = data[position]
        holder.bind(listItem)

        //Picasso.get().load(menuList[position].img).into(holder.image)
        holder.txtName.text = data[position].name

        holder.image.load(data[position].img) {
            crossfade(true)
            placeholder(R.drawable.pizza1)
        }
    }
}