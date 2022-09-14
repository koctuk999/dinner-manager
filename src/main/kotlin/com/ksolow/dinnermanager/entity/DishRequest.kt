package com.ksolow.dinnermanager.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class DishRequest(
    @JsonProperty(required = true)
    val title: String,
    @JsonProperty(required = false)
    val description: String?,
    @JsonProperty(required = true)
    val dishTime: String,
    @JsonProperty(required = true)
    val recipe: String,
    @JsonProperty(required = true)
    val ingredients: List<String>,
)

