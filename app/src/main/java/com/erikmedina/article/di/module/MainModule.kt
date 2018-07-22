package com.erikmedina.article.di.module

import com.erikmedina.article.domain.interactor.GetContentListInteractor
import com.erikmedina.article.domain.interactor.GetContentListInteractorImpl
import com.erikmedina.article.domain.repository.Repository
import com.erikmedina.article.presentation.main.MainContract
import com.erikmedina.article.presentation.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providePresenter(presenter: MainPresenter): MainContract.Presenter {
        return presenter
    }

    @Provides
    fun provideGetContentList(
            repository: Repository): GetContentListInteractor {
        return GetContentListInteractorImpl(repository)
    }
}
