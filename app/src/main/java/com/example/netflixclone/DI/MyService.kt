package com.example.netflixclone.DI

import com.example.netflixclone.Repository.EditProfileRepository.EditProfileRepositoryRepository
import com.example.netflixclone.Repository.MainRepository.MainViewModelRepository
import com.example.netflixclone.ViewModel.EditProfileViewModel
import com.example.netflixclone.ViewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    single { MainViewModelRepository() }
    single { EditProfileRepositoryRepository() }
}

val viewModelModule = module {
    viewModel { MainViewModel(get(), androidApplication()) }
    viewModel { EditProfileViewModel(get(), androidApplication()) }
}
