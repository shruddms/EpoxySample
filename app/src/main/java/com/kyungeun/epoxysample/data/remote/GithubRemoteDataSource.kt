package com.kyungeun.epoxysample.data.remote

import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(
    private val githubService: GithubService
) : BaseDataSource() {
    suspend fun getProfile(name: String) = getResult { githubService.getProfile(name) }
    suspend fun getUserProjects(name: String) = getResult { githubService.getUserProjects(name) }
}
