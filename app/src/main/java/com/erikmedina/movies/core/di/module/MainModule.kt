package com.erikmedina.movies.core.di.module

import com.erikmedina.movies.domain.interactor.GetContentInteractor
import com.erikmedina.movies.domain.interactor.GetContentInteractorImpl
import com.erikmedina.movies.domain.interactor.GetContentListInteractor
import com.erikmedina.movies.domain.interactor.GetContentListInteractorImpl
import com.erikmedina.movies.feature.movie.MainContract
import com.erikmedina.movies.feature.movie.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providePresenter(presenter: MainPresenter): MainContract.Presenter {
        return presenter
    }

    @Provides
    fun provideGetContentListInteractor(getContentListInteractorImpl: GetContentListInteractorImpl)
            : GetContentListInteractor {
        return getContentListInteractorImpl
    }

    @Provides
    fun provideGetContentInteractor(getContentInteractorImpl: GetContentInteractorImpl)
            : GetContentInteractor {
        return getContentInteractorImpl
    }
}