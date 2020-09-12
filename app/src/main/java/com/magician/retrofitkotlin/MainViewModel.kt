package com.magician.retrofitkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magician.retrofitkotlin.model.Post
import com.magician.retrofitkotlin.repo.Repo
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repo: Repo) : ViewModel() {
    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<Post>> = MutableLiveData()
    val myCustomResponse: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    val myCustomResponse2: MutableLiveData<Response<List<Post>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response: Response<Post> = repo.getPost()
            myResponse.value = response
        }
    }

    fun getPost2(number: Int) {
        viewModelScope.launch {
            val response: Response<Post> = repo.getPost2(number)
            myResponse2.value = response
        }
    }

    fun getCustomPost(userId: Int, sort: String, desc: String) {
        viewModelScope.launch {
            val response: Response<List<Post>> = repo.getCustomPost(userId, sort, desc)
            myCustomResponse.value = response
        }
    }

    fun getCustomPost2(userId: Int, options: Map<String, String>) {
        viewModelScope.launch {
            val response: Response<List<Post>> = repo.getCustomPost2(userId, options)
            myCustomResponse2.value = response
        }
    }
}