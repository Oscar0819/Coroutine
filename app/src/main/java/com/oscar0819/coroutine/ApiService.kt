package com.oscar0819.coroutine

import com.google.gson.JsonObject
import com.oscar0819.coroutine.model.PostResponse
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/posts")
    suspend fun post(
        @Body jsonString: JSONObject
    ): Response<PostResponse>
}