package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: WishlistAdapter
    private val items = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = WishlistAdapter(items)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.submitBtn.setOnClickListener {
            val name = binding.inputName.text.toString()
            val price = binding.inputPrice.text.toString()
            val url = binding.inputUrl.text.toString()

            if (name.isNotEmpty() && price.isNotEmpty() && url.isNotEmpty()) {
                val item = WishlistItem(name, price, url)
                adapter.addItem(item)

                binding.inputName.text.clear()
                binding.inputPrice.text.clear()
                binding.inputUrl.text.clear()
            }
        }
    }
}
