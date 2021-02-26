package com.cornerjob.marvelheroes.data.repository.datasource

import com.cornerjob.marvelheroes.data.model.MarvelHeroResponse
import io.reactivex.Observable

interface MarvelHeroesDataSource {

    fun getMarvelHeroesList(): Observable<List<MarvelHeroResponse>>

}