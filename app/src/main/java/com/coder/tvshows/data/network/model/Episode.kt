package com.coder.tvshows.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Episode(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("url")
    @Expose
    val url: String?,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("season")
    @Expose
    val season: String?,
    @SerializedName("number")
    @Expose
    val number: Int?,
    @SerializedName("airdate")
    @Expose
    val airdate: String?,
    @SerializedName("airtime")
    @Expose
    val airtime: String?,
    @SerializedName("runtime")
    @Expose
    val runtime: String?,
    @SerializedName("show")
    @Expose
    val show: Show
)