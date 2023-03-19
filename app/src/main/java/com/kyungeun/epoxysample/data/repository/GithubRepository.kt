package com.kyungeun.epoxysample.data.repository

import com.kyungeun.epoxysample.data.remote.GithubRemoteDataSource
import com.kyungeun.epoxysample.util.performGetOperation
import javax.inject.Inject

class GithubRepository @Inject constructor(
    private val remoteDataSource: GithubRemoteDataSource
) {
    fun getProfile(name: String) = performGetOperation(
        networkCall = { remoteDataSource.getProfile(name) }
    )

    fun getUserProjects(name: String) = performGetOperation(
        networkCall = { remoteDataSource.getUserProjects(name) }
    )
}
