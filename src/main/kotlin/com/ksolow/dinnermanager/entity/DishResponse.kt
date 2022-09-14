package com.ksolow.dinnermanager.entity

data class DishResponse(
    val id: String,
    val title: String,
    val description: String?,
    val dishTime: String,
    val recipe: String,
    val ingredients: List<String>,
)
