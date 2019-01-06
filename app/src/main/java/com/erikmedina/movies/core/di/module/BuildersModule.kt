package com.erikmedina.movies.core.di.module

import com.erikmedina.movies.feature.movie.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Binds all sub-components within the app.
 */
@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun bindMainActivity(): MainActivity

    // Add bindings for other sub-components here
}
