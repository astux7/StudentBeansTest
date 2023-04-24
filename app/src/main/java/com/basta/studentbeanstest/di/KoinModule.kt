package com.basta.studentbeanstest.di

import com.basta.studentbeanstest.presentation.image_list.ImageListViewModel
import com.basta.studentbeanstest.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object KoinModule {
    fun allModule(): List<Module> = listOf(viewModelModule,)

    private val viewModelModule: Module
        get() = module {
            viewModel { LoginViewModel() }
            viewModel { ImageListViewModel() }
        }
}