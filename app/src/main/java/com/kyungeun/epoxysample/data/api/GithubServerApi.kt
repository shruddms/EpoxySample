package com.kyungeun.epoxysample.data.api

import com.kyungeun.epoxysample.data.model.Profile
import com.kyungeun.epoxysample.data.model.Project
import com.kyungeun.epoxysample.data.model.ProjectWrapper
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubServerApi {

    @GET("users/{name}")
    fun retrieveProfileFlowable(@Path("name") name: String): Profile

    @GET("users/{name}/repos")
    fun retrieveUserProjectsFlowable(
        @Path("name") name: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Project>

    @GET("search/repositories")
    fun retrieveProjectsFlowable(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String
    ): ProjectWrapper

}