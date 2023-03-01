package com.kyungeun.epoxysample.data.model

import com.google.gson.annotations.SerializedName

data class ProjectWrapper(
    @SerializedName("total_count") val totalCount: Int?,
    @SerializedName("incomplete_results") val incompleteResults: Boolean?,
    @SerializedName("items") val items: List<Project>?
)