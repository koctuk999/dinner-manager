package com.ksolow.dinnermanager.config

import com.mongodb.ConnectionString
import org.litote.kmongo.KMongo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.mongo.MongoProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(MongoProperties::class)
class MongoClientConfig(@Autowired val properties: MongoProperties) {
    @Bean
    fun createClient() = KMongo.createClient(ConnectionString(properties.uri))
}