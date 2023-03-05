package com.kyungeun.epoxysample.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.kyungeun.epoxysample.data.remote.GithubRemoteDataSource
import com.kyungeun.epoxysample.data.remote.GithubService
import com.kyungeun.epoxysample.data.remote.NullOnEmptyConverterFactory
import com.kyungeun.epoxysample.data.repository.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(NullOnEmptyConverterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideCharacterService(retrofit: Retrofit): GithubService = retrofit.create(GithubService::class.java)

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(service: GithubService) = GithubRemoteDataSource(service)

    @Singleton
    @Provides
    fun provideRepository(
        remoteDataSource: GithubRemoteDataSource
    ) =
        GithubRepository(remoteDataSource)
}
