package com.coder.tvshows.di.module

import androidx.lifecycle.ViewModelProvider
import com.coder.tvshows.di.TvViewModelFactory
import com.coder.tvshows.ui.today.TodaysTvShowsActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector(modules = [TodayFragmentBuildersModule::class])
    internal abstract fun contributeTodaysActivity(): TodaysTvShowsActivity
}