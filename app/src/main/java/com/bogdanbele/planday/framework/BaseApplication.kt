package com.bogdanbele.planday.framework

import android.app.Application
import android.content.Context
import com.bogdanbele.planday.core.ApplicationComponent
import com.bogdanbele.planday.core.ApplicationModule
import com.bogdanbele.planday.core.DaggerApplicationComponent

class BaseApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule())
            .build()
        applicationComponent.inject(this)

    }
    companion object {
        operator fun get(context: Context): BaseApplication {
            return context.applicationContext as BaseApplication
        }
    }
}