package com.bogdanbele.planday.core

import android.app.Application
import android.content.Context
import com.bogdanbele.planday.MainActivityViewModel
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.api.GuidesApi
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module
class ApplicationModule {
    lateinit var application: Application

    fun ApplicationModule(application: Application){
        this.application = application
    }

    @Provides
    fun getViewModel(): MainActivityViewModel = MainActivityViewModel()

    @Provides
    fun getApi(): AppApi = AppApi()

    @Provides
    @Singleton
    fun providesApplication(): Context = application
}