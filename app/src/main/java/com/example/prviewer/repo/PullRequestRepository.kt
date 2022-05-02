package com.example.prviewer.repo

import android.util.Log
import com.example.prviewer.model.PullRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class PullRequestRepository : IRepository {
    private val TAG = this.javaClass.name
    private val client = WebClient.client

    override suspend fun getPullRequests(dispatcher: CoroutineDispatcher): List<PullRequest>? =
        withContext(dispatcher) {
            try {
                val response =
                    client.getPullRequests(Constants.openPrEndpoint)
                Log.d("Pull Requests", "Success ${response.body().toString()}")
                response.body()
            } catch (ex: Exception) {
                Log.e(TAG, "Error while fetch pull requests $ex")
                emptyList()
            }
        }
}