package com.insearching.megaverse

import android.app.Application
import com.insearching.megaverse.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MegaverseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MegaverseApp)
            androidLogger()

            modules(appModule)
        }
    }
}