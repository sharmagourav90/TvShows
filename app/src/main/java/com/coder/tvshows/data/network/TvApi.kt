package com.coder.tvshows.data.network

import com.coder.tvshows.data.network.model.Episode
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TvApi {
    @GET("/schedule")
    fun getCurrentSchedule(
        @Query("country") country: String,
        @Query("date") date: String
    ): Single<List<Episode>>
}