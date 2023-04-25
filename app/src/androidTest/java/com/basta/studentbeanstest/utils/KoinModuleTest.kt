package com.basta.studentbeanstest.utils

import com.basta.studentbeanstest.domain.repository.PhotoRepository
import com.basta.studentbeanstest.domain.use_case.authenticate.AuthenticateUseCase
import com.basta.studentbeanstest.domain.use_case.get_photos.GetPhotosUseCase
import com.basta.studentbeanstest.domain.use_case.validate_email.ValidateEmailUseCase
import com.basta.studentbeanstest.domain.use_case.validate_password.ValidatePasswordUseCase
import com.basta.studentbeanstest.presentation.image_list.ImageListViewModel
import com.basta.studentbeanstest.presentation.sign_in.SignInViewModel
import com.basta.studentbeanstest.repository.PhotoRepositoryFake
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object KoinModuleTest {
    fun successModule(): List<Module> =
        listOf(
            repositoryModule,
            useCaseModule,
            viewModelModule,
        )

    fun failModule(): List<Module> =
        listOf(
            failRepositoryModule,
            useCaseModule,
            viewModelModule,
        )

    private val useCaseModule: Module
        get() = module {
            factory { GetPhotosUseCase(get()) }
            factory { ValidateEmailUseCase() }
            factory { ValidatePasswordUseCase() }
            factory { AuthenticateUseCase() }
        }

    private val repositoryModule: Module
        get() = module {
            single<PhotoRepository> { PhotoRepositoryFake() }
        }

    private val failRepositoryModule: Module
        get() = module {
            single<PhotoRepository> { PhotoRepositoryFake(true) }
        }

    private val viewModelModule: Module
        get() = module {
            viewModel { SignInViewModel(get(), get(), get()) }
            viewModel { ImageListViewModel(get()) }
        }
}