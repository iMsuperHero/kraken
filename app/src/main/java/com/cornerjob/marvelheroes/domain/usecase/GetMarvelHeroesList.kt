package com.cornerjob.marvelheroes.domain.usecase

import com.cornerjob.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.cornerjob.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable
import javax.inject.Inject

class GetMarvelHeroesList @Inject constructor(val marvelHeroesRepositoryImpl: MarvelHeroesRepositoryImpl)
    : UseCase<List<MarvelHeroEntity>>() {

    override fun buildCase(): Observable<List<MarvelHeroEntity>> =
            marvelHeroesRepositoryImpl.getMarvelHeroesList()

}