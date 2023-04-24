package com.basta.studentbeanstest.di

import com.basta.studentbeanstest.common.Constants
import com.basta.studentbeanstest.data.remote.PhotoApi
import com.basta.studentbeanstest.data.repository.PhotoRepositoryImpl
import com.basta.studentbeanstest.domain.repository.PhotoRepository
import com.basta.studentbeanstest.domain.use_case.get_photos.GetPhotosUseCase
import com.basta.studentbeanstest.presentation.image_list.ImageListViewModel
import com.basta.studentbeanstest.presentation.sign_in.SignInViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object KoinModule {
    fun allModule(): List<Module> =
        listOf(
            mainModule,
            apiModule,
            repositoryModule,
            useCaseModule,
            viewModelModule
        )



    private val useCaseModule: Module
        get() = module {
            factory { GetPhotosUseCase(get()) }
        }

    private val mainModule: Module
        get() = module {
            factory {
                OkHttpClient.Builder()
                    .callTimeout(1, TimeUnit.MINUTES)
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .build()
            }

            single {
                Retrofit.Builder()
                    .client(get())
                    .baseUrl(Constants.IMAGE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }

    private val apiModule: Module
        get() = module {
            single { get<Retrofit>().create(PhotoApi::class.java) }
        }

    private val repositoryModule: Module
        get() = module {
            single<PhotoRepository> { PhotoRepositoryImpl(get()) }
        }

    private val viewModelModule: Module
        get() = module {
            viewModel { SignInViewModel() }
            viewModel { ImageListViewModel(get()) }
        }
}