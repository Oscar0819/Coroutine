package com.oscar0819.coroutine

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar0819.coroutine.model.PostResponse
import com.oscar0819.coroutine.repository.PostRepository
import com.oscar0819.coroutine.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
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
}