package com.ksolow.dinnermanager.controller

import com.ksolow.dinnermanager.entity.Dish
import com.ksolow.dinnermanager.services.DinnerRepository
import org.slf4j.LoggerFactory.getLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dinner")
class DinnerController {

    @Autowired
    lateinit var repository: DinnerRepository

    private val log = getLogger(DinnerController::class.java)

    @PostMapping("/dish/upsert", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun addDish(@RequestBody request: Dish): ResponseEntity<Dish> {
        repository.addDish(request)
        log.info("added new dish ${request.title}")
        return ResponseEntity.ok(request)
    }
}