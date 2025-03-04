package com.oscar0819.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar0819.coroutine.model.PostResponse
import com.oscar0819.coroutine.repository.PostRepository
import com.oscar0819.coroutine.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
): ViewModel() {
    fun post(userId: Int, title: String, body: String ) = viewModelScope.launch {
        val jsonBody = "{userId:\"$userId\", title:\"$title\", body:\"$body\"}"

        val jo = JSONObject().apply {
            put("userId", userId)
            put("title", title)
            put("body", body)
        }

        val result = postRepository.makePostRequest(jo)


        Log.d("ewp", result.toString())
    }

    fun post() = viewModelScope.launch {

    }

    fun testWithContextAndCoroutineScope() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            delay(5000)
            Log.d("test", "withContext reached")
        }

//        CoroutineScope(Dispatchers.IO).launch {
//            delay(5000)
//            Log.d("test", "CoroutineScope reached")
//        }

        delay(2000)
        Log.d("test", "End viewModelScope")
    }
}