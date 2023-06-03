package com.example.lesson_3_6

import android.content.Intent
import android.icu.util.ULocale
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_3_6.adapter.CategoryAdapter
import com.example.lesson_3_6.adapter.ProductAdapter
import com.example.lesson_3_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var arrayList: ArrayList<ULocale.Category>
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var categoryRecyclerView: RecyclerView
    lateinit var binding: ActivityMainBinding

    lateinit var productAdapter : ProductAdapter
    lateinit var productRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    setAdapters()
}

private fun setCategory(): ArrayList<ULocale.Category> {
    return arrayListOf(
        ULocale.Category("Takeaways"),
        ULocale.Category(R.drawable.image_grocery, "Grocery"),
        ULocale.Category(R.drawable.image_convenience, "Convenience"),
        ULocale.Category(R.drawable.image_pharmacy, "Pharmacy")
    )
}

private fun setProducts() : ArrayList<Product> {
    return arrayListOf(
        Product("Burger Craze", R.drawable.image_burger_craze, true, 4.6, 601, "American", "Burgers", "FREE", "$10", "15-20 min", "1.5 km"),
        Product("Vegetarian Pizza", R.drawable.image_vegetarian_pizza, false, 4.6, 784, "Italian", "Burgers", "FREE", "$10", "10-15 min", "0.8 km"),
        Product("Fried Chicken", R.drawable.image_convenience, true, 4.8, 460, "Kentucky", "Fast Food", "10%", "$13", "20-25 min", "2.3 km"),
        Product("Indian Samosa", R.drawable.image_burger_craze, false, 4.5, 537, "Indian", "Foods", "$5", "$8", "15-20 min", "1.4 km"),
        Product("Pepperoni Pizza", R.drawable.image_vegetarian_pizza, true, 3.9, 893, "French", "Pizzas", "FREE", "$9", "5-10 min", "0.2 km"),
    )
}
private fun setAdapters() {
    categoryAdapter = CategoryAdapter(setCategory())
    categoryRecyclerView = binding.recyclerViewCategory
    categoryRecyclerView.adapter = categoryAdapter

    productAdapter = ProductAdapter(setProducts()) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("product", it)
        startActivity(intent)
    }
    productRecyclerView = binding.recyclerViewProducts
    productRecyclerView.adapter = productAdapter
   }
}


