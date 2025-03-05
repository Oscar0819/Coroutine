package com.oscar0819.coroutine.datasource

import com.oscar0819.coroutine.ApiService
import com.oscar0819.coroutine.model.PostResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class PostRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    val posts: Flow<List<PostResponse>> = flow {
        val posts = apiService.getPosts()

//        if (posts.isSuccessful) {
//            emit(posts.body()!!)
//        } else {
//            emit()
//        }

    }
}