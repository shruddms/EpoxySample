package com.kyungeun.epoxysample.data.remote

import com.kyungeun.epoxysample.data.model.Profile
import com.kyungeun.epoxysample.data.model.Project
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("users/{name}")
    suspend fun getProfile(@Path("name") name: String): Response<Profile>

    @GET("users/{name}/repos")
    suspend fun getUserProjects(
        @Path("name") name: String
    ): Response<List<Project>>
}