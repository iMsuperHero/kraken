package com.cornerjob.marvelheroes.di.modules

import com.cornerjob.marvelheroes.domain.repository.MarvelHeroesRepositoryImpl
import com.cornerjob.marvelheroes.di.scopes.PerActivity
import com.cornerjob.marvelheroes.domain.usecase.GetMarvelHeroesList
import com.cornerjob.marvelheroes.presentation.heroeslist.HeroesListActivity
import com.cornerjob.marvelheroes.presentation.heroeslist.HeroesListContract
import dagger.Module
import dagger.Provides

@Module
class GetMarvelHeroesListModule(private val view: HeroesListActivity) {

    @Provides
    @PerActivity
    fun provideView(): HeroesListContract.View = view

    @Provides
    @PerActivity
    fun provideGetListHeroesUseCase(marvelHeroesRepositoryImpl: MarvelHeroesRepositoryImpl): GetMarvelHeroesList =
            GetMarvelHeroesList(marvelHeroesRepositoryImpl)

}