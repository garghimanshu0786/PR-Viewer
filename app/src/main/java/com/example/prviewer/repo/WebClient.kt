package com.example.prviewer.repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebClient {
    private fun getApi(): GithubAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(GithubAPI::class.java)
    }

    var client: GithubAPI = getApi()
}