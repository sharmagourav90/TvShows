package com.coder.tvshows.data

import androidx.lifecycle.LiveData
import com.coder.tvshows.data.Resource.Success

class LiveDataResource<T> : LiveData<Resource<T>>() {
    private lateinit var resource: Resource<T>

    internal fun set(data: T) {
        resource = Success(data)
        postValue(resource)
    }

    internal fun loading() {
        resource = Resource.Loading()
        postValue(resource)
    }

    internal fun error(t: Throwable) {
        resource = Resource.Failure(t)
        postValue(resource)
    }
}