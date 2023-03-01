package com.kyungeun.epoxysample.data.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("location") val location: String?,
    @SerializedName("bio") val bio: String?,
    @SerializedName("blog") val blog: String?
)