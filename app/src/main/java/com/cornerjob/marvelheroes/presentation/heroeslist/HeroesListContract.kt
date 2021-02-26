package com.cornerjob.marvelheroes.presentation.heroeslist

import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity
import com.cornerjob.marvelheroes.presentation.base.BasePresenter

interface HeroesListContract {

    interface View {

        fun showLoading(isLoading: Boolean)

        fun showHeroesList(heroes: List<MarvelHeroEntity>)

        fun showError(message: String)

        fun showError(messageRes: Int)

    }

    interface Presenter : BasePresenter {

        fun loadMarvelHeroes()

    }

}