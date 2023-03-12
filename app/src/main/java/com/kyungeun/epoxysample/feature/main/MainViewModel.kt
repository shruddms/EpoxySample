package com.kyungeun.epoxysample.feature.main

import androidx.lifecycle.ViewModel
import com.kyungeun.epoxysample.data.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GithubRepository
) : ViewModel() {

    private val name = "shruddms"

    val profile = repository.getProfile(name)

    val userProjects = repository.getUserProjects(name)
}
