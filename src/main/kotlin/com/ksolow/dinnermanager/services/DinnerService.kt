package com.ksolow.dinnermanager.services

import com.ksolow.dinnermanager.entity.DishRequest
import com.ksolow.dinnermanager.entity.DishResponse
import com.ksolow.dinnermanager.entity.DishTime
import com.ksolow.dinnermanager.entity.ErrorResponse
import org.json.JSONObject
import org.litote.kmongo.json
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class DinnerService {

    @Autowired
    lateinit var repository: DinnerRepository

    private val log = LoggerFactory.getLogger(DinnerService::class.java)

    fun addDish(dish: DishRequest): ResponseEntity<Any> =
        if (dish.dishTime !in DishTime.values().map { it.value }) {
            val error = "Invalid parameter dishTime (${dish.dishTime}), available values [breakfast,lunch,dinner,bonus]"
            log.warn(error)
            ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                    ErrorResponse(
                        type = "IllegalParameters",
                        message = error
                    )
                )
        } else {
            val id = JSONObject(repository.addDish(dish)!!.json).getString("\$oid")
            log.info("added new dish ${dish.title}: $id")
            ResponseEntity.ok(
                with(dish) {
                    DishResponse(
                        id = id,
                        title = title,
                        dishTime = dishTime,
                        recipe = recipe,
                        description = description,
                        ingredients = ingredients
                    )
                }
            )
        }
}
