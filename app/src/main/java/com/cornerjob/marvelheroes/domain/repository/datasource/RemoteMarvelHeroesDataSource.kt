package com.cornerjob.marvelheroes.domain.repository.datasource

import com.cornerjob.marvelheroes.data.model.MarvelHeroResponse
import com.cornerjob.marvelheroes.data.net.MarvelHeroesService
import io.reactivex.Observable

class RemoteMarvelHeroesDataSource(private val marvelHeroesService: MarvelHeroesService) :
        MarvelHeroesDataSource {

    override fun getMarvelHeroesList(): Observable<List<MarvelHeroResponse>> =
            marvelHeroesService.getMarvelHeroesList().map { it.heroesData.superheroes }

}