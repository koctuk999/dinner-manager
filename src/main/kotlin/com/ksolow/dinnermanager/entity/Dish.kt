package com.ksolow.dinnermanager.entity

data class Dish(
    val title: String,
    val description: String?,
    val dishTime: String,
    val recipe: String,
    val ingredients: List<String>,
)

enum class DishTime(val value: String) {
    BREAKFAST("Завтрак"),
    LUNCH("Обед"),
    DINNER("Ужин"),
    BONUS("Дополнительно")
}
