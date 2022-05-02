package com.example.prviewer.repo

import com.example.prviewer.model.PullRequest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface GithubAPI {

    @GET
    suspend fun getPullRequests(@Url url: String?): Response<List<PullRequest>>
}