package com.ksolow.dinnermanager.controller

import com.ksolow.dinnermanager.entity.DishRequest
import com.ksolow.dinnermanager.services.DinnerService
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
    lateinit var dinnerService: DinnerService

    @PostMapping("/dish/upsert", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun addDish(@RequestBody request: DishRequest) = ResponseEntity.ok(
        dinnerService.addDish(request)
    )
}