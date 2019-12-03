package com.coder.tvshows.data

import androidx.lifecycle.MutableLiveData
import com.coder.tvshows.data.network.TvNetworkDataSource
import com.coder.tvshows.data.network.model.Episode
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvNetworkRepository @Inject constructor(private val dataSource: TvNetworkDataSource) {
    private val disposable = CompositeDisposable()

    fun getTodaysShowList(): MutableLiveData<Resource<List<Episode>>> {
        val todaysShowList = MutableLiveData<Resource<List<Episode>>>()

        todaysShowList.value = Resource.Loading()

        dataSource.getTodaysShowList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                Consumer { data ->
                    todaysShowList.value = Resource.Success(data)
                },
                Consumer { error -> todaysShowList.value = Resource.Failure(error) })
            .addTo(disposable)

        return todaysShowList
    }

    fun clear() {
        disposable.dispose()
    }
}