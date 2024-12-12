package com.example.simpleloginpage.di

import com.example.simpleloginpage.data.datasource.LoginDataSource
import com.example.simpleloginpage.data.repository.LoginRepositoryImpl
import com.example.simpleloginpage.domain.repository.LoginRepository
import com.example.simpleloginpage.domain.usecases.LoginUseCase
import com.example.simpleloginpage.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

    val appModule = module {
        // DataSource
        single { LoginDataSource() }

        // Repository
        single<LoginRepository> { LoginRepositoryImpl(get()) }

        // UseCase
        single { LoginUseCase(get()) }

        // ViewModel
        viewModel { LoginViewModel(get()) }
    }