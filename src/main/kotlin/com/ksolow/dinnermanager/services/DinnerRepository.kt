package com.ksolow.dinnermanager.services

import com.ksolow.dinnermanager.entity.Dish
import com.mongodb.client.MongoClient
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class DinnerRepository(@Autowired val mongoClient: MongoClient) {
    val db by lazy {
        mongoClient.getDatabase("dinner-manager")
    }

    fun addDish(dish: Dish) {
        db.getCollection<Dish>().insertOne(dish)
    }

}