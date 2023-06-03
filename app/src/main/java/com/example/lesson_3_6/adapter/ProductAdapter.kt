package com.example.lesson_3_6.adapter

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson_3_6.Product

class ProductAdapter (var arrayList: ArrayList<Product>, var onClick : (Product) -> Unit) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(arrayList[position])
        holder.itemView.setOnClickListener{
            onClick(arrayList[position])
        }
    }

    inner class ProductViewHolder(var binding : ItemProductsBinding) : RecyclerView.ViewHolder(binding.root){

        private lateinit var image : ImageView
        lateinit var name : TextView
        lateinit var discount : TextView
        lateinit var rate : TextView
        lateinit var parts : TextView
        lateinit var place : TextView
        lateinit var category : TextView
        lateinit var delivery : TextView
        lateinit var minPrice : TextView
        lateinit var time : TextView
        private lateinit var distance : TextView


        private fun setViews(product: Product){
            image.setImageResource(product.image)
            name.text = product.name
            rate.text = product.rate.toString()
            parts.text = product.parts.toString()
            place.text = product.place
            category.text = product.category
            delivery.text = product.delivery
            minPrice.text = product.minPrice
            time.text = product.time
            distance.text = product.distance
            setDiscount(product)
        }

        private fun setDiscount(product: Product){
            if(product.discount) {
                discount.visibility = VISIBLE
            } else {
                discount.visibility = GONE
            }
        }

        fun onBind(product : Product){
            setViews(product)

        }
    }
}

private fun ItemProductsBinding.Companion.inflate(
    from: LayoutInflater?,
    parent: ViewGroup,
    b: Boolean
): ItemProductsBinding {
    TODO("Not yet implemented")
}
