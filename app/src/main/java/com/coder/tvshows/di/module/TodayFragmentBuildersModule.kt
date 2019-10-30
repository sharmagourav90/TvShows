package com.coder.tvshows.di.module

import com.coder.tvshows.ui.today.list.TodaysShowListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TodayFragmentBuildersModule {
    @ContributesAndroidInjector
    internal abstract fun contributeShowListFragment(): TodaysShowListFragment
}