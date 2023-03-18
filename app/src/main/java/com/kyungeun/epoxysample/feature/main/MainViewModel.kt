package com.kyungeun.epoxysample.feature.main

import androidx.lifecycle.ViewModel
import com.kyungeun.epoxysample.data.repository.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: GithubRepository
) : ViewModel() {

    private val name = "shruddms"

    val userProjects = repository.getUserProjects(name)
}
