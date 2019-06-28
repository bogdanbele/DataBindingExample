package com.bogdanbele.planday.core

import com.bogdanbele.planday.MainActivity
import com.bogdanbele.planday.MainActivityViewModel
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.framework.BaseApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent{
    fun inject(application: BaseApplication)
    fun inject(mainActivity: MainActivity)
    fun inject(mainActivityViewModel: MainActivityViewModel)
    fun inject(appApi: AppApi)
}