package com.oscar0819.coroutine.repository

import com.oscar0819.coroutine.model.PostResponse
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

class PostRepository(

) {
    private val postsUrl = "https://jsonplaceholder.typicode.com/posts"

//    suspend fun makePostRequest(
//        jsonBody: String
//    ): Result<PostResponse> {
//        return withContext(Dispatchers.IO) {
//
//        }
//    }
}