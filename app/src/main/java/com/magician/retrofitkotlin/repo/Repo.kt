package com.magician.retrofitkotlin.repo

import com.magician.retrofitkotlin.api.RetrofitInstance
import com.magician.retrofitkotlin.model.Post
import retrofit2.Response

class Repo {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPost2(number: Int): Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }

    suspend fun getCustomPost(userId: Int, sort: String, desc: String): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost(userId, sort, desc)
    }

    suspend fun getCustomPost2(userId: Int, options: Map<String, String>): Response<List<Post>> {
        return RetrofitInstance.api.getCustomPost2(userId, options)
    }
}