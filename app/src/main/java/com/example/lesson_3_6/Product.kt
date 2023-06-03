package com.example.lesson_3_6

import android.os.Parcelable

abstract class Product (val name: String,
                        val image: Int,
                        val discount: Boolean,
                        val rate: Double,
                        val parts: Int,
                        val place: String,
                        val category: String,
                        val delivery: String,
                        val minPrice: String,
                        val time: String,
                        val distance: String
    ) : Parcelable
