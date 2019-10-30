package com.coder.tvshows.ui.today.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.coder.tvshows.data.Resource
import com.coder.tvshows.data.TvNetworkRepository
import com.coder.tvshows.data.network.model.Episode
import com.coder.tvshows.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TodaysShowListViewModel @Inject constructor(private val repository: TvNetworkRepository) :
    BaseViewModel() {
    val todaysShowList: LiveData<Resource<List<Episode>>> by lazy { _todaysShowList }
    private val _todaysShowList = MutableLiveData<Resource<List<Episode>>>()

    private val disposable = CompositeDisposable()

    init {
        getTodaysShowList()
    }

    private fun getTodaysShowList() {
        _todaysShowList.postValue(Resource.Loading())
        repository.getTodaysShowList().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe(Consumer { data ->
                _todaysShowList.postValue(Resource.Success(data))
            },
                Consumer { error -> _todaysShowList.postValue(Resource.Failure(error)) })
            .addTo(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}