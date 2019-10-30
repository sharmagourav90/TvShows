package com.coder.tvshows.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Show(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("url")
    @Expose
    val url: String?,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("type")
    @Expose
    val type: String?,
    @SerializedName("language")
    @Expose
    val language: String?,
    @SerializedName("genres")
    @Expose
    val genres: List<String>?,
    @SerializedName("status")
    @Expose
    val status: String?,
    @SerializedName("runtime")
    @Expose
    val runtime: Int?,
    @SerializedName("premiered")
    @Expose
    val premiered: String?,
    @SerializedName("officialSite")
    @Expose
    val officialSite: String?,
    @SerializedName("network")
    @Expose
    val airChannel: Channel?,
    @SerializedName("webChannel")
    @Expose
    val webChannel: Channel?,
    @SerializedName("image")
    @Expose
    val image: Map<String, String>?,
    @SerializedName("externals")
    @Expose
    val externalInfo: ExternalInfo?,
    @SerializedName("summary")
    @Expose
    val summary: String?,
    @SerializedName("rating")
    @Expose
    val rating: Map<String, String>?
) {
    data class Channel(
        @SerializedName("name")
        @Expose
        val name: String,
        @SerializedName("code")
        @Expose
        val code: String,
        @SerializedName("timezone")
        @Expose
        val timezone: String
    )

    data class ExternalInfo(
        @SerializedName("tvrage")
        @Expose
        val tvrage: String?,
        @SerializedName("thetvdb")
        @Expose
        val thetvdb: Long?,
        @SerializedName("imdb")
        @Expose
        val imdb: String?
    )
}