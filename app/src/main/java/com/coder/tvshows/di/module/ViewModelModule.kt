package com.coder.tvshows.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.coder.tvshows.di.TvViewModelFactory
import com.coder.tvshows.di.ViewModelKey
import com.coder.tvshows.ui.today.list.TodaysShowListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(TodaysShowListViewModel::class)
    internal abstract fun bindShowListViewModels(showListViewModel: TodaysShowListViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: TvViewModelFactory): ViewModelProvider.Factory
}