package com.erikmedina.movies.core.di.module

import com.erikmedina.movies.domain.interactor.GetContentInteractor
import com.erikmedina.movies.domain.interactor.GetContentInteractorImpl
import com.erikmedina.movies.domain.interactor.GetContentListInteractor
import com.erikmedina.movies.domain.interactor.GetContentListInteractorImpl
import com.erikmedina.movies.domain.repository.Repository
import com.erikmedina.movies.presentation.main.MainContract
import com.erikmedina.movies.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providePresenter(presenter: MainPresenter): MainContract.Presenter {
        return presenter
    }

    @Provides
    fun provideGetContentListInteractor(
            repository: Repository): GetContentListInteractor {
        return GetContentListInteractorImpl(repository)
    }

    @Provides
    fun provideGetContentInteractor(repository: Repository): GetContentInteractor {
        return GetContentInteractorImpl(repository)
    }
}
