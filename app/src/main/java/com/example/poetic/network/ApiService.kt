package com.example.poetic.network

import com.example.poetic.model.Poem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("random/5")
    suspend fun getRandomPoems(): Response<List<Poem>>
}