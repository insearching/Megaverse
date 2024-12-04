package com.insearching.megaverse.di

import androidx.work.WorkManager
import com.insearching.megaverse.app.data.networking.RemoteMegaverseDataSource
import com.insearching.megaverse.app.presentation.MegaverseViewModel
import com.insearching.megaverse.core.data.networking.HttpClientFactory
import com.insearching.megaverse.core.domain.MegaverseDataSource
import io.ktor.client.engine.cio.CIO
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    single { WorkManager.getInstance(androidContext()) }
    singleOf(::RemoteMegaverseDataSource).bind<MegaverseDataSource>()

    viewModelOf(::MegaverseViewModel)
}