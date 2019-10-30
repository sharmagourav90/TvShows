package com.coder.tvshows.data

import com.coder.tvshows.data.network.TvNetworkDataSource
import com.coder.tvshows.data.network.model.Episode
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvNetworkRepository @Inject constructor(private val dataSource: TvNetworkDataSource) {
    fun getTodaysShowList() = dataSource.getTodaysShowList()
}