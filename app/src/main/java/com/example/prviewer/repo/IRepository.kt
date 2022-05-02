package com.example.prviewer.repo

import com.example.prviewer.model.PullRequest
import kotlinx.coroutines.CoroutineDispatcher

interface IRepository {
    suspend fun getPullRequests(dispatcher: CoroutineDispatcher): List<PullRequest>?
}