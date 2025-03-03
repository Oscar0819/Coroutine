package com.oscar0819.coroutine

import androidx.lifecycle.ViewModel
import com.oscar0819.coroutine.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostViewModel (
    private val postRepository: PostRepository
): ViewModel() {
    fun post() {

    }
}