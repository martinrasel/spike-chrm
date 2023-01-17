package de.bembelnaut.spike.chr.domain

import com.squareup.moshi.Json

data class Joke(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "joke") val joke: String
)
