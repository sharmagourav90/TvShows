package com.coder.tvshows.di.component

import android.app.Application
import com.coder.tvshows.TvShowsApp
import com.coder.tvshows.di.module.ActivityBuilderModule
import com.coder.tvshows.di.module.AppModule
import com.coder.tvshows.di.module.NetworkModule
import com.coder.tvshows.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class, ActivityBuilderModule::class,
        NetworkModule::class, ViewModelModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}