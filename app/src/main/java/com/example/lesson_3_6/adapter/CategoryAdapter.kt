package com.example.lesson_3_6.adapter

import android.icu.util.ULocale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

private val Any.title: CharSequence?
    get() {
        TODO("Not yet implemented")
    }
private val Any.image: Int
    get() {
        TODO("Not yet implemented")
    }
private val Any.textViewTitle: TextView
    get() {
        TODO("Not yet implemented")
    }
private val Any.imageViewMiniHamb: ImageView
    get() {
        TODO("Not yet implemented")
    }
private val Unit.root: View
    get() {
        TODO("Not yet implemented")
    }

class CategoryAdapter(var arrayList: ArrayList<ULocale.Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    inner class CategoryViewHolder(var binding: Unit) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var image: ImageView
        lateinit var title: TextView
        private fun findViews() {
            image = binding.imageViewMiniHamb
            title = binding.textViewTitle
        }

        fun onBind(category: ULocale.Category) {
            findViews()
            image.setImageResource(category.image)
            title.text = category.title
        }
    }
}