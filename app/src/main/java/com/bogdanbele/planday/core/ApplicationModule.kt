package com.bogdanbele.planday.core

import android.app.Application
import android.content.Context
import com.bogdanbele.planday.MainActivityViewModel
import com.bogdanbele.planday.api.AppApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    lateinit var application: Application

    @Provides
    fun getViewModel(): MainActivityViewModel = MainActivityViewModel()

    @Provides
    fun getApi(): AppApi = AppApi()

    @Provides
    @Singleton
    fun providesApplication(): Context = application
}