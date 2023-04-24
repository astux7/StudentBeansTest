package com.basta.studentbeanstest

import android.app.Application
import com.basta.studentbeanstest.di.KoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class StudentBeansTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StudentBeansTestApplication)
            modules(KoinModule.allModule())
        }
    }
}
