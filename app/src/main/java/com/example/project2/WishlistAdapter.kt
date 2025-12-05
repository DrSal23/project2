package com.example.project2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.databinding.ItemWishlistBinding

class WishlistAdapter(private val items: MutableList<WishlistItem>)
    : RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemWishlistBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWishlistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.itemName.text = item.name
        holder.binding.itemPrice.text = item.price
        holder.binding.itemUrl.text = item.url
    }

    fun addItem(item: WishlistItem) {
        items.add(item)
        notifyItemInserted(items.size - 1)
    }
}
