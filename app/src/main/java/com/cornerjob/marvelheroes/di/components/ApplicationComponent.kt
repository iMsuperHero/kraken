package com.cornerjob.marvelheroes.di.components

import android.content.Context
import com.cornerjob.marvelheroes.data.net.MarvelHeroesService
import com.cornerjob.marvelheroes.domain.repository.MarvelHeroesRepositoryImpl
import com.cornerjob.marvelheroes.di.modules.ApplicationModule
import com.cornerjob.marvelheroes.di.modules.DataModule
import com.cornerjob.marvelheroes.di.modules.NetModule
import com.cornerjob.marvelheroes.presentation.util.Navigator
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetModule::class, DataModule::class])
interface ApplicationComponent {

    fun getContext(): Context
    fun getRepository(): MarvelHeroesRepositoryImpl
    fun getHeroService(): MarvelHeroesService
    fun getNavigator(): Navigator

}