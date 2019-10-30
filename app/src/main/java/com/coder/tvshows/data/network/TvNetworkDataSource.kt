package com.coder.tvshows.data.network

import javax.inject.Inject

class TvNetworkDataSource @Inject constructor(private val tvApi: TvApi) {
    fun getTodaysShowList() =
        tvApi.getCurrentSchedule("US", "2019-10-07")
}