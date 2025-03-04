package com.oscar0819.coroutine.repository

import android.os.Looper
import android.util.Log
import com.google.gson.JsonObject
import com.oscar0819.coroutine.ApiService
import com.oscar0819.coroutine.model.PostResponse
import com.oscar0819.coroutine.utils.AppCoroutineDispatchers
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Inject
import javax.inject.Singleton

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}

@Singleton
class PostRepository @Inject constructor(
    private val apiService: ApiService,
    private val dispatchers: AppCoroutineDispatchers,
) {
    suspend fun makePostRequest(
        jsonObject: JSONObject
    ): Result<PostResponse> = withContext(dispatchers.io) {
        return@withContext try {
            Log.d("thread", "isMain = ${Looper.myLooper() == Looper.getMainLooper() }")

            val response = apiService.post(jsonObject)
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Result.Error(Exception("Error: ${response.code()} ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

//    fun getPost(): Flow<PostResponse> { }
}