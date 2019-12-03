package com.coder.tvshows.ui.today.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.coder.tvshows.data.Resource
import com.coder.tvshows.data.TvNetworkRepository
import com.coder.tvshows.data.network.model.Episode
import com.coder.tvshows.ui.base.BaseViewModel
import javax.inject.Inject

class TodaysShowListViewModel @Inject constructor(private val repository: TvNetworkRepository) :
    BaseViewModel() {
    val todaysShowList: LiveData<Resource<List<Episode>>> by lazy { _todaysShowList }
    private val _todaysShowList = MediatorLiveData<Resource<List<Episode>>>()

    init {
        _todaysShowList.addSource(repository.getTodaysShowList(), Observer {
            _todaysShowList.value = it
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.clear()
    }
}