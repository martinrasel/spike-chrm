package de.bembelnaut.spike.chr.service.datasource.joke

import de.bembelnaut.spike.chr.domain.Joke
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {

    @GET("Programming")
    suspend fun getAnyJoke(@Query("type") type: String): Joke
}