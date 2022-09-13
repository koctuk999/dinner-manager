package com.ksolow.dinnermanager.controller

import org.springframework.http.ResponseEntity
import org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/monitoring")
class PingController {

    @GetMapping("/ping", produces = [APPLICATION_JSON_VALUE])
    fun getPing() = ResponseEntity.ok(
        mapOf("result" to "Success")
    )
}