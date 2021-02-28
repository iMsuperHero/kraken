package com.cornerjob.marvelheroes.di.components

import com.cornerjob.marvelheroes.di.modules.GetMarvelHeroesListModule
import com.cornerjob.marvelheroes.di.scopes.PerActivity
import com.cornerjob.marvelheroes.presentation.heroeslist.HeroesListActivity
import dagger.Component

@PerActivity
@Component(modules = [GetMarvelHeroesListModule::class], dependencies = [ApplicationComponent::class])
interface GetMarvelHeroesListComponent {

    fun inject(marvelListActivity: HeroesListActivity)

}