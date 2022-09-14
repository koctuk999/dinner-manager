package com.ksolow.dinnermanager.services

import com.ksolow.dinnermanager.entity.DishRequest
import com.ksolow.dinnermanager.entity.DishResponse
import org.json.JSONObject
import org.litote.kmongo.json
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DinnerService {

    @Autowired
    lateinit var repository: DinnerRepository

    private val log = LoggerFactory.getLogger(DinnerService::class.java)

    fun addDish(dish: DishRequest): DishResponse = with(dish) {
        val id = JSONObject(repository.addDish(dish)!!.json).getString("\$oid")
        log.info("added new dish ${dish.title}: $id")
        DishResponse(
            id = id,
            title = title,
            dishTime = dishTime,
            recipe = recipe,
            description = description,
            ingredients = ingredients
        )
    }
}
