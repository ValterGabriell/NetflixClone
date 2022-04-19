package com.example.netflixclone.DI

import com.example.netflixclone.Repository.MainViewModel.MainViewModelRepository
import com.example.netflixclone.ViewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { MainViewModelRepository() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get(), androidApplication()) }
}
