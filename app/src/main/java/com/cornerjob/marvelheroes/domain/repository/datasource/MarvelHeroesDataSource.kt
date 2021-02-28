package com.cornerjob.marvelheroes.domain.repository.datasource

import com.cornerjob.marvelheroes.data.model.MarvelHeroResponse
import io.reactivex.Observable

interface MarvelHeroesDataSource {

    fun getMarvelHeroesList(): Observable<List<MarvelHeroResponse>>

}