package com.diegoalvis.travelperktest

import android.app.Application
import com.diegoalvis.data._di.dataModule
import com.diegoalvis.travelperktest._di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApp)
            // declare modules
            modules(dataModule, appModule)
        }
    }
}