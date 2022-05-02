package com.example.prviewer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.prviewer.model.PullRequest
import com.example.prviewer.repo.IRepository
import com.example.prviewer.repo.PullRequestRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class PRListViewModel() : ViewModel() {
    private val repository: IRepository
        get() = PullRequestRepository()

    private val _pullRequests = MutableLiveData<List<PullRequest>>()

    val pullRequests: LiveData<List<PullRequest>>
        get() = _pullRequests

    init {
        viewModelScope.launch {
            _pullRequests.postValue(repository.getPullRequests(IO))
        }
    }
}